/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ @Internal
/*     */ public class EntryUtils
/*     */ {
/*     */   @Internal
/*     */   public static void copyNodeRecursively(Entry paramEntry, DirectoryEntry paramDirectoryEntry) throws IOException {
/*  41 */     DirectoryEntry directoryEntry = null;
/*  42 */     if (paramEntry.isDirectoryEntry()) {
/*     */       
/*  44 */       DirectoryEntry directoryEntry1 = (DirectoryEntry)paramEntry;
/*  45 */       directoryEntry = paramDirectoryEntry.createDirectory(paramEntry.getName());
/*  46 */       directoryEntry.setStorageClsid(directoryEntry1.getStorageClsid());
/*  47 */       Iterator<Entry> iterator = directoryEntry1.getEntries();
/*     */       
/*  49 */       while (iterator.hasNext())
/*     */       {
/*  51 */         copyNodeRecursively(iterator.next(), directoryEntry);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  56 */       DocumentEntry documentEntry = (DocumentEntry)paramEntry;
/*  57 */       DocumentInputStream documentInputStream = new DocumentInputStream(documentEntry);
/*  58 */       paramDirectoryEntry.createDocument(documentEntry.getName(), documentInputStream);
/*  59 */       documentInputStream.close();
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
/*     */   public static void copyNodes(DirectoryEntry paramDirectoryEntry1, DirectoryEntry paramDirectoryEntry2) throws IOException {
/*  74 */     for (Entry entry : paramDirectoryEntry1) {
/*  75 */       copyNodeRecursively(entry, paramDirectoryEntry2);
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
/*     */   public static void copyNodes(FilteringDirectoryNode paramFilteringDirectoryNode1, FilteringDirectoryNode paramFilteringDirectoryNode2) throws IOException {
/*  90 */     copyNodes(paramFilteringDirectoryNode1, paramFilteringDirectoryNode2);
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
/*     */   public static void copyNodes(DirectoryEntry paramDirectoryEntry1, DirectoryEntry paramDirectoryEntry2, List<String> paramList) throws IOException {
/* 108 */     Iterator<Entry> iterator = paramDirectoryEntry1.getEntries();
/* 109 */     while (iterator.hasNext()) {
/*     */       
/* 111 */       Entry entry = iterator.next();
/* 112 */       if (!paramList.contains(entry.getName()))
/*     */       {
/* 114 */         copyNodeRecursively(entry, paramDirectoryEntry2);
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
/*     */   
/*     */   public static void copyNodes(OPOIFSFileSystem paramOPOIFSFileSystem1, OPOIFSFileSystem paramOPOIFSFileSystem2) throws IOException {
/* 130 */     copyNodes(paramOPOIFSFileSystem1.getRoot(), paramOPOIFSFileSystem2.getRoot());
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
/*     */   public static void copyNodes(NPOIFSFileSystem paramNPOIFSFileSystem1, NPOIFSFileSystem paramNPOIFSFileSystem2) throws IOException {
/* 143 */     copyNodes(paramNPOIFSFileSystem1.getRoot(), paramNPOIFSFileSystem2.getRoot());
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
/*     */   public static void copyNodes(OPOIFSFileSystem paramOPOIFSFileSystem1, OPOIFSFileSystem paramOPOIFSFileSystem2, List<String> paramList) throws IOException {
/* 159 */     copyNodes(new FilteringDirectoryNode(paramOPOIFSFileSystem1.getRoot(), paramList), new FilteringDirectoryNode(paramOPOIFSFileSystem2.getRoot(), paramList));
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
/*     */   public static void copyNodes(NPOIFSFileSystem paramNPOIFSFileSystem1, NPOIFSFileSystem paramNPOIFSFileSystem2, List<String> paramList) throws IOException {
/* 177 */     copyNodes(new FilteringDirectoryNode(paramNPOIFSFileSystem1.getRoot(), paramList), new FilteringDirectoryNode(paramNPOIFSFileSystem2.getRoot(), paramList));
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
/*     */   public static boolean areDirectoriesIdentical(DirectoryEntry paramDirectoryEntry1, DirectoryEntry paramDirectoryEntry2) {
/* 193 */     if (!paramDirectoryEntry1.getName().equals(paramDirectoryEntry2.getName())) {
/* 194 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 198 */     if (paramDirectoryEntry1.getEntryCount() != paramDirectoryEntry2.getEntryCount()) {
/* 199 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 203 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 204 */     short s = -12345;
/* 205 */     for (Entry entry : paramDirectoryEntry1) {
/* 206 */       String str = entry.getName();
/* 207 */       if (entry.isDirectoryEntry()) {
/* 208 */         hashMap.put(str, Integer.valueOf(-12345)); continue;
/*     */       } 
/* 210 */       hashMap.put(str, Integer.valueOf(((DocumentNode)entry).getSize()));
/*     */     } 
/*     */     
/* 213 */     for (Entry entry : paramDirectoryEntry2) {
/* 214 */       int i; String str = entry.getName();
/* 215 */       if (!hashMap.containsKey(str))
/*     */       {
/* 217 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 221 */       if (entry.isDirectoryEntry()) {
/* 222 */         i = -12345;
/*     */       } else {
/* 224 */         i = ((DocumentNode)entry).getSize();
/*     */       } 
/* 226 */       if (i != ((Integer)hashMap.get(str)).intValue())
/*     */       {
/* 228 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 232 */       hashMap.remove(str);
/*     */     } 
/* 234 */     if (!hashMap.isEmpty())
/*     */     {
/* 236 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 240 */     for (Entry entry : paramDirectoryEntry1) {
/*     */       try {
/* 242 */         boolean bool; Entry entry1 = paramDirectoryEntry2.getEntry(entry.getName());
/*     */         
/* 244 */         if (entry.isDirectoryEntry()) {
/* 245 */           bool = areDirectoriesIdentical((DirectoryEntry)entry, (DirectoryEntry)entry1);
/*     */         } else {
/*     */           
/* 248 */           bool = areDocumentsIdentical((DocumentEntry)entry, (DocumentEntry)entry1);
/*     */         } 
/*     */         
/* 251 */         if (!bool) return false; 
/* 252 */       } catch (FileNotFoundException fileNotFoundException) {
/*     */         
/* 254 */         return false;
/* 255 */       } catch (IOException iOException) {
/*     */         
/* 257 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 262 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean areDocumentsIdentical(DocumentEntry paramDocumentEntry1, DocumentEntry paramDocumentEntry2) throws IOException {
/* 271 */     if (!paramDocumentEntry1.getName().equals(paramDocumentEntry2.getName()))
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     if (paramDocumentEntry1.getSize() != paramDocumentEntry2.getSize())
/*     */     {
/* 277 */       return false;
/*     */     }
/*     */     
/* 280 */     boolean bool = true;
/* 281 */     DocumentInputStream documentInputStream1 = null, documentInputStream2 = null; try {
/*     */       int i, j;
/* 283 */       documentInputStream1 = new DocumentInputStream(paramDocumentEntry1);
/* 284 */       documentInputStream2 = new DocumentInputStream(paramDocumentEntry2);
/*     */ 
/*     */       
/*     */       do {
/* 288 */         i = documentInputStream1.read();
/* 289 */         j = documentInputStream2.read();
/* 290 */         if (i != j) {
/* 291 */           bool = false;
/*     */           break;
/*     */         } 
/* 294 */       } while (i != -1 && j != -1);
/*     */     } finally {
/* 296 */       if (documentInputStream1 != null) documentInputStream1.close(); 
/* 297 */       if (documentInputStream2 != null) documentInputStream2.close();
/*     */     
/*     */     } 
/* 300 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\EntryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */