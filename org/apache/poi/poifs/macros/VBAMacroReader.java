/*     */ package org.apache.poi.poifs.macros;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.RLEDecompressingInputStream;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VBAMacroReader
/*     */   implements Closeable
/*     */ {
/*     */   protected static final String VBA_PROJECT_OOXML = "vbaProject.bin";
/*     */   protected static final String VBA_PROJECT_POIFS = "VBA";
/*     */   private NPOIFSFileSystem fs;
/*     */   private static final int EOF = -1;
/*     */   private static final int VERSION_INDEPENDENT_TERMINATOR = 16;
/*     */   private static final int VERSION_DEPENDENT_TERMINATOR = 43;
/*     */   private static final int PROJECTVERSION = 9;
/*     */   private static final int PROJECTCODEPAGE = 3;
/*     */   private static final int STREAMNAME = 26;
/*     */   private static final int MODULEOFFSET = 49;
/*     */   private static final int MODULETYPE_PROCEDURAL = 33;
/*     */   private static final int MODULETYPE_DOCUMENT_CLASS_OR_DESIGNER = 34;
/*     */   private static final int PROJECTLCID = 2;
/*     */   
/*     */   public VBAMacroReader(InputStream paramInputStream) throws IOException {
/*  60 */     PushbackInputStream pushbackInputStream = new PushbackInputStream(paramInputStream, 8);
/*  61 */     byte[] arrayOfByte = IOUtils.peekFirst8Bytes(pushbackInputStream);
/*     */     
/*  63 */     if (NPOIFSFileSystem.hasPOIFSHeader(arrayOfByte)) {
/*  64 */       this.fs = new NPOIFSFileSystem(pushbackInputStream);
/*     */     } else {
/*  66 */       openOOXML(pushbackInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public VBAMacroReader(File paramFile) throws IOException {
/*     */     try {
/*  72 */       this.fs = new NPOIFSFileSystem(paramFile);
/*  73 */     } catch (OfficeXmlFileException officeXmlFileException) {
/*  74 */       openOOXML(new FileInputStream(paramFile));
/*     */     } 
/*     */   }
/*     */   public VBAMacroReader(NPOIFSFileSystem paramNPOIFSFileSystem) {
/*  78 */     this.fs = paramNPOIFSFileSystem;
/*     */   }
/*     */   
/*     */   private void openOOXML(InputStream paramInputStream) throws IOException {
/*  82 */     ZipInputStream zipInputStream = new ZipInputStream(paramInputStream);
/*     */     ZipEntry zipEntry;
/*  84 */     while ((zipEntry = zipInputStream.getNextEntry()) != null) {
/*  85 */       if (StringUtil.endsWithIgnoreCase(zipEntry.getName(), "vbaProject.bin")) {
/*     */         
/*     */         try {
/*  88 */           this.fs = new NPOIFSFileSystem(zipInputStream);
/*     */           return;
/*  90 */         } catch (IOException iOException) {
/*     */           
/*  92 */           zipInputStream.close();
/*     */ 
/*     */           
/*  95 */           throw iOException;
/*     */         } 
/*     */       }
/*     */     } 
/*  99 */     zipInputStream.close();
/* 100 */     throw new IllegalArgumentException("No VBA project found");
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 104 */     this.fs.close();
/* 105 */     this.fs = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> readMacros() throws IOException {
/* 115 */     ModuleMap moduleMap = new ModuleMap();
/* 116 */     findMacros(this.fs.getRoot(), moduleMap);
/*     */     
/* 118 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 119 */     for (Map.Entry<String, Module> entry : moduleMap.entrySet()) {
/* 120 */       Module module = (Module)entry.getValue();
/* 121 */       if (module.buf != null && module.buf.length > 0) {
/* 122 */         hashMap.put(entry.getKey(), new String(module.buf, moduleMap.charset));
/*     */       }
/*     */     } 
/* 125 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   protected static class Module { Integer offset;
/*     */     byte[] buf;
/*     */     
/*     */     void read(InputStream param1InputStream) throws IOException {
/* 132 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 133 */       IOUtils.copy(param1InputStream, byteArrayOutputStream);
/* 134 */       byteArrayOutputStream.close();
/* 135 */       this.buf = byteArrayOutputStream.toByteArray();
/*     */     } }
/*     */   
/*     */   protected static class ModuleMap extends HashMap<String, Module> {
/* 139 */     Charset charset = Charset.forName("Cp1252");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void findMacros(DirectoryNode paramDirectoryNode, ModuleMap paramModuleMap) throws IOException {
/* 153 */     if ("VBA".equalsIgnoreCase(paramDirectoryNode.getName())) {
/*     */       
/* 155 */       readMacros(paramDirectoryNode, paramModuleMap);
/*     */     } else {
/*     */       
/* 158 */       for (Entry entry : paramDirectoryNode) {
/* 159 */         if (entry instanceof DirectoryNode) {
/* 160 */           findMacros((DirectoryNode)entry, paramModuleMap);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String readString(InputStream paramInputStream, int paramInt, Charset paramCharset) throws IOException {
/* 176 */     byte[] arrayOfByte = new byte[paramInt];
/* 177 */     int i = paramInputStream.read(arrayOfByte);
/* 178 */     return new String(arrayOfByte, 0, i, paramCharset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void readModule(RLEDecompressingInputStream paramRLEDecompressingInputStream, String paramString, ModuleMap paramModuleMap) throws IOException {
/* 194 */     int i = paramRLEDecompressingInputStream.readInt();
/* 195 */     Module module = paramModuleMap.get(paramString);
/* 196 */     if (module == null) {
/*     */       
/* 198 */       module = new Module();
/* 199 */       module.offset = Integer.valueOf(i);
/* 200 */       paramModuleMap.put(paramString, module);
/*     */     }
/*     */     else {
/*     */       
/* 204 */       RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(new ByteArrayInputStream(module.buf, i, module.buf.length - i));
/*     */ 
/*     */       
/* 207 */       module.read((InputStream)rLEDecompressingInputStream);
/* 208 */       rLEDecompressingInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void readModule(DocumentInputStream paramDocumentInputStream, String paramString, ModuleMap paramModuleMap) throws IOException {
/* 213 */     Module module = paramModuleMap.get(paramString);
/*     */     
/* 215 */     if (module == null) {
/*     */       
/* 217 */       module = new Module();
/* 218 */       paramModuleMap.put(paramString, module);
/* 219 */       module.read((InputStream)paramDocumentInputStream);
/*     */     } else {
/* 221 */       if (module.offset == null)
/*     */       {
/* 223 */         throw new IOException("Module offset for '" + paramString + "' was never read.");
/*     */       }
/*     */       
/* 226 */       long l = paramDocumentInputStream.skip(module.offset.intValue());
/* 227 */       if (l != module.offset.intValue()) {
/* 228 */         throw new IOException("tried to skip " + module.offset + " bytes, but actually skipped " + l + " bytes");
/*     */       }
/* 230 */       RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream((InputStream)paramDocumentInputStream);
/* 231 */       module.read((InputStream)rLEDecompressingInputStream);
/* 232 */       rLEDecompressingInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void trySkip(InputStream paramInputStream, long paramLong) throws IOException {
/* 243 */     long l = paramInputStream.skip(paramLong);
/* 244 */     if (l != paramLong) {
/* 245 */       if (l < 0L) {
/* 246 */         throw new IOException("Tried skipping " + paramLong + " bytes, but no bytes were skipped. " + "The end of the stream has been reached or the stream is closed.");
/*     */       }
/*     */ 
/*     */       
/* 250 */       throw new IOException("Tried skipping " + paramLong + " bytes, but only " + l + " bytes were skipped. " + "This should never happen.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void readMacros(DirectoryNode paramDirectoryNode, ModuleMap paramModuleMap) throws IOException {
/* 276 */     for (Entry entry : paramDirectoryNode) {
/* 277 */       if (!(entry instanceof DocumentNode))
/*     */         continue; 
/* 279 */       String str = entry.getName();
/* 280 */       DocumentNode documentNode = (DocumentNode)entry;
/* 281 */       DocumentInputStream documentInputStream = new DocumentInputStream((DocumentEntry)documentNode);
/*     */       try {
/* 283 */         if ("dir".equalsIgnoreCase(str)) {
/*     */           
/* 285 */           RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream((InputStream)documentInputStream);
/* 286 */           String str1 = null;
/* 287 */           int i = 0; try {
/*     */             while (true) {
/*     */               int k;
/* 290 */               i = rLEDecompressingInputStream.readShort();
/* 291 */               if (-1 == i || 16 == i) {
/*     */                 break;
/*     */               }
/*     */               
/* 295 */               int j = rLEDecompressingInputStream.readInt();
/* 296 */               switch (i) {
/*     */                 case 9:
/* 298 */                   trySkip((InputStream)rLEDecompressingInputStream, 6L);
/*     */                   continue;
/*     */                 case 3:
/* 301 */                   k = rLEDecompressingInputStream.readShort();
/* 302 */                   paramModuleMap.charset = Charset.forName("Cp" + k);
/*     */                   continue;
/*     */                 case 26:
/* 305 */                   str1 = readString((InputStream)rLEDecompressingInputStream, j, paramModuleMap.charset);
/*     */                   continue;
/*     */                 case 49:
/* 308 */                   readModule(rLEDecompressingInputStream, str1, paramModuleMap);
/*     */                   continue;
/*     */               } 
/* 311 */               trySkip((InputStream)rLEDecompressingInputStream, j);
/*     */             }
/*     */           
/*     */           }
/* 315 */           catch (IOException iOException) {
/* 316 */             throw new IOException("Error occurred while reading macros at section id " + i + " (" + HexDump.shortToHex(i) + ")", iOException);
/*     */           
/*     */           }
/*     */           finally {
/*     */             
/* 321 */             rLEDecompressingInputStream.close();
/*     */           } 
/* 323 */         } else if (!StringUtil.startsWithIgnoreCase(str, "__SRP") && !StringUtil.startsWithIgnoreCase(str, "_VBA_PROJECT")) {
/*     */ 
/*     */           
/* 326 */           readModule(documentInputStream, str, paramModuleMap);
/*     */         } 
/*     */       } finally {
/*     */         
/* 330 */         documentInputStream.close();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\macros\VBAMacroReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */