/*     */ package org.apache.poi.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIOLE2TextExtractor;
/*     */ import org.apache.poi.POITextExtractor;
/*     */ import org.apache.poi.hssf.OldExcelFormatException;
/*     */ import org.apache.poi.hssf.extractor.EventBasedExcelExtractor;
/*     */ import org.apache.poi.hssf.extractor.ExcelExtractor;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class OLE2ExtractorFactory
/*     */ {
/*  57 */   private static final POILogger LOGGER = POILogFactory.getLogger(OLE2ExtractorFactory.class);
/*     */ 
/*     */   
/*  60 */   private static final ThreadLocal<Boolean> threadPreferEventExtractors = new ThreadLocal<Boolean>() {
/*     */       protected Boolean initialValue() {
/*  62 */         return Boolean.FALSE;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Boolean allPreferEventExtractors;
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getThreadPrefersEventExtractors() {
/*  74 */     return ((Boolean)threadPreferEventExtractors.get()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Boolean getAllThreadsPreferEventExtractors() {
/*  83 */     return allPreferEventExtractors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setThreadPrefersEventExtractors(boolean paramBoolean) {
/*  91 */     threadPreferEventExtractors.set(Boolean.valueOf(paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setAllThreadsPreferEventExtractors(Boolean paramBoolean) {
/*  99 */     allPreferEventExtractors = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean getPreferEventExtractor() {
/* 107 */     if (allPreferEventExtractors != null) {
/* 108 */       return allPreferEventExtractors.booleanValue();
/*     */     }
/* 110 */     return ((Boolean)threadPreferEventExtractors.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static POIOLE2TextExtractor createExtractor(POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/* 115 */     return (POIOLE2TextExtractor)createExtractor(paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */   
/*     */   public static POIOLE2TextExtractor createExtractor(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 119 */     return (POIOLE2TextExtractor)createExtractor(paramNPOIFSFileSystem.getRoot());
/*     */   }
/*     */   
/*     */   public static POIOLE2TextExtractor createExtractor(OPOIFSFileSystem paramOPOIFSFileSystem) throws IOException {
/* 123 */     return (POIOLE2TextExtractor)createExtractor(paramOPOIFSFileSystem.getRoot());
/*     */   }
/*     */   
/*     */   public static POITextExtractor createExtractor(InputStream paramInputStream) throws IOException {
/* 127 */     Class<?> clazz = getOOXMLClass();
/* 128 */     if (clazz != null) {
/*     */       
/*     */       try {
/* 131 */         Method method = clazz.getDeclaredMethod("createExtractor", new Class[] { InputStream.class });
/* 132 */         return (POITextExtractor)method.invoke(null, new Object[] { paramInputStream });
/* 133 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 134 */         throw illegalArgumentException;
/* 135 */       } catch (Exception exception) {
/* 136 */         throw new IllegalArgumentException("Error creating Extractor for InputStream", exception);
/*     */       } 
/*     */     }
/*     */     
/* 140 */     return (POITextExtractor)createExtractor(new NPOIFSFileSystem(paramInputStream));
/*     */   }
/*     */ 
/*     */   
/*     */   private static Class<?> getOOXMLClass() {
/*     */     try {
/* 146 */       return OLE2ExtractorFactory.class.getClassLoader().loadClass("org.apache.poi.extractor.ExtractorFactory");
/*     */     
/*     */     }
/* 149 */     catch (ClassNotFoundException classNotFoundException) {
/* 150 */       LOGGER.log(5, new Object[] { "POI OOXML jar missing" });
/* 151 */       return null;
/*     */     } 
/*     */   }
/*     */   private static Class<?> getScratchpadClass() {
/*     */     try {
/* 156 */       return OLE2ExtractorFactory.class.getClassLoader().loadClass("org.apache.poi.extractor.OLE2ScratchpadExtractorFactory");
/*     */     
/*     */     }
/* 159 */     catch (ClassNotFoundException classNotFoundException) {
/* 160 */       LOGGER.log(7, new Object[] { "POI Scratchpad jar missing" });
/* 161 */       throw new IllegalStateException("POI Scratchpad jar missing, required for ExtractorFactory");
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
/*     */   public static POITextExtractor createExtractor(DirectoryNode paramDirectoryNode) throws IOException {
/* 175 */     for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
/* 176 */       if (paramDirectoryNode.hasEntry(str)) {
/* 177 */         if (getPreferEventExtractor()) {
/* 178 */           return (POITextExtractor)new EventBasedExcelExtractor(paramDirectoryNode);
/*     */         }
/* 180 */         return (POITextExtractor)new ExcelExtractor(paramDirectoryNode);
/*     */       } 
/*     */     } 
/* 183 */     if (paramDirectoryNode.hasEntry("Book")) {
/* 184 */       throw new OldExcelFormatException("Old Excel Spreadsheet format (1-95) found. Please call OldExcelExtractor directly for basic text extraction");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 189 */     Class<?> clazz = getScratchpadClass();
/*     */     try {
/* 191 */       Method method = clazz.getDeclaredMethod("createExtractor", new Class[] { DirectoryNode.class });
/* 192 */       POITextExtractor pOITextExtractor = (POITextExtractor)method.invoke(null, new Object[] { paramDirectoryNode });
/* 193 */       if (pOITextExtractor != null) return pOITextExtractor; 
/* 194 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 195 */       throw illegalArgumentException;
/* 196 */     } catch (Exception exception) {
/* 197 */       throw new IllegalArgumentException("Error creating Scratchpad Extractor", exception);
/*     */     } 
/*     */     
/* 200 */     throw new IllegalArgumentException("No supported documents found in the OLE2 stream");
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
/*     */   public static POITextExtractor[] getEmbededDocsTextExtractors(POIOLE2TextExtractor paramPOIOLE2TextExtractor) throws IOException {
/* 214 */     ArrayList<Entry> arrayList = new ArrayList();
/*     */     
/* 216 */     ArrayList arrayList1 = new ArrayList();
/*     */ 
/*     */     
/* 219 */     DirectoryEntry directoryEntry = paramPOIOLE2TextExtractor.getRoot();
/* 220 */     if (directoryEntry == null) {
/* 221 */       throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
/*     */     }
/*     */     
/* 224 */     if (paramPOIOLE2TextExtractor instanceof ExcelExtractor) {
/*     */       
/* 226 */       Iterator<Entry> iterator = directoryEntry.getEntries();
/* 227 */       while (iterator.hasNext()) {
/* 228 */         Entry entry = iterator.next();
/* 229 */         if (entry.getName().startsWith("MBD")) {
/* 230 */           arrayList.add(entry);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 235 */       Class<?> clazz = getScratchpadClass();
/*     */       try {
/* 237 */         Method method = clazz.getDeclaredMethod("identifyEmbeddedResources", new Class[] { POIOLE2TextExtractor.class, List.class, List.class });
/*     */         
/* 239 */         method.invoke(null, new Object[] { paramPOIOLE2TextExtractor, arrayList, arrayList1 });
/* 240 */       } catch (Exception exception) {
/* 241 */         throw new IllegalArgumentException("Error checking for Scratchpad embedded resources", exception);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 246 */     if (arrayList.size() == 0 && arrayList1.size() == 0) {
/* 247 */       return new POITextExtractor[0];
/*     */     }
/*     */     
/* 250 */     ArrayList<POITextExtractor> arrayList2 = new ArrayList();
/* 251 */     for (Entry entry : arrayList) {
/* 252 */       arrayList2.add(createExtractor((DirectoryNode)entry));
/*     */     }
/*     */ 
/*     */     
/* 256 */     for (InputStream inputStream : arrayList1) {
/*     */       try {
/* 258 */         arrayList2.add(createExtractor(inputStream));
/* 259 */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */         
/* 262 */         LOGGER.log(5, new Object[] { illegalArgumentException });
/* 263 */       } catch (Exception exception) {
/*     */         
/* 265 */         LOGGER.log(5, new Object[] { exception });
/*     */       } 
/*     */     } 
/* 268 */     return arrayList2.<POITextExtractor>toArray(new POITextExtractor[arrayList2.size()]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\extractor\OLE2ExtractorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */