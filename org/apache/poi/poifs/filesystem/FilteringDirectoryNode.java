/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.hpsf.ClassID;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilteringDirectoryNode
/*     */   implements DirectoryEntry
/*     */ {
/*     */   private Set<String> excludes;
/*     */   private Map<String, List<String>> childExcludes;
/*     */   private DirectoryEntry directory;
/*     */   
/*     */   public FilteringDirectoryNode(DirectoryEntry paramDirectoryEntry, Collection<String> paramCollection) {
/*  64 */     this.directory = paramDirectoryEntry;
/*     */ 
/*     */     
/*  67 */     this.excludes = new HashSet<String>();
/*  68 */     this.childExcludes = new HashMap<String, List<String>>();
/*  69 */     for (String str1 : paramCollection) {
/*  70 */       int i = str1.indexOf('/');
/*  71 */       if (i == -1) {
/*     */         
/*  73 */         this.excludes.add(str1);
/*     */         continue;
/*     */       } 
/*  76 */       String str2 = str1.substring(0, i);
/*  77 */       String str3 = str1.substring(i + 1);
/*  78 */       if (!this.childExcludes.containsKey(str2)) {
/*  79 */         this.childExcludes.put(str2, new ArrayList<String>());
/*     */       }
/*  81 */       ((List<String>)this.childExcludes.get(str2)).add(str3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public DirectoryEntry createDirectory(String paramString) throws IOException {
/*  87 */     return this.directory.createDirectory(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public DocumentEntry createDocument(String paramString, InputStream paramInputStream) throws IOException {
/*  92 */     return this.directory.createDocument(paramString, paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public DocumentEntry createDocument(String paramString, int paramInt, POIFSWriterListener paramPOIFSWriterListener) throws IOException {
/*  97 */     return this.directory.createDocument(paramString, paramInt, paramPOIFSWriterListener);
/*     */   }
/*     */   
/*     */   public Iterator<Entry> getEntries() {
/* 101 */     return new FilteringIterator();
/*     */   }
/*     */   
/*     */   public Iterator<Entry> iterator() {
/* 105 */     return getEntries();
/*     */   }
/*     */   
/*     */   public int getEntryCount() {
/* 109 */     int i = this.directory.getEntryCount();
/* 110 */     for (String str : this.excludes) {
/* 111 */       if (this.directory.hasEntry(str)) {
/* 112 */         i--;
/*     */       }
/*     */     } 
/* 115 */     return i;
/*     */   }
/*     */   
/*     */   public Set<String> getEntryNames() {
/* 119 */     HashSet<String> hashSet = new HashSet();
/* 120 */     for (String str : this.directory.getEntryNames()) {
/* 121 */       if (!this.excludes.contains(str)) {
/* 122 */         hashSet.add(str);
/*     */       }
/*     */     } 
/* 125 */     return hashSet;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 129 */     return (getEntryCount() == 0);
/*     */   }
/*     */   
/*     */   public boolean hasEntry(String paramString) {
/* 133 */     if (this.excludes.contains(paramString)) {
/* 134 */       return false;
/*     */     }
/* 136 */     return this.directory.hasEntry(paramString);
/*     */   }
/*     */   
/*     */   public Entry getEntry(String paramString) throws FileNotFoundException {
/* 140 */     if (this.excludes.contains(paramString)) {
/* 141 */       throw new FileNotFoundException(paramString);
/*     */     }
/*     */     
/* 144 */     Entry entry = this.directory.getEntry(paramString);
/* 145 */     return wrapEntry(entry);
/*     */   }
/*     */   private Entry wrapEntry(Entry paramEntry) {
/* 148 */     String str = paramEntry.getName();
/* 149 */     if (this.childExcludes.containsKey(str) && paramEntry instanceof DirectoryEntry) {
/* 150 */       return new FilteringDirectoryNode((DirectoryEntry)paramEntry, this.childExcludes.get(str));
/*     */     }
/*     */     
/* 153 */     return paramEntry;
/*     */   }
/*     */   
/*     */   public ClassID getStorageClsid() {
/* 157 */     return this.directory.getStorageClsid();
/*     */   }
/*     */   
/*     */   public void setStorageClsid(ClassID paramClassID) {
/* 161 */     this.directory.setStorageClsid(paramClassID);
/*     */   }
/*     */   
/*     */   public boolean delete() {
/* 165 */     return this.directory.delete();
/*     */   }
/*     */   
/*     */   public boolean renameTo(String paramString) {
/* 169 */     return this.directory.renameTo(paramString);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 173 */     return this.directory.getName();
/*     */   }
/*     */   
/*     */   public DirectoryEntry getParent() {
/* 177 */     return this.directory.getParent();
/*     */   }
/*     */   
/*     */   public boolean isDirectoryEntry() {
/* 181 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDocumentEntry() {
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   private class FilteringIterator implements Iterator<Entry> {
/*     */     private Iterator<Entry> parent;
/*     */     private Entry next;
/*     */     
/*     */     private FilteringIterator() {
/* 193 */       this.parent = FilteringDirectoryNode.this.directory.getEntries();
/* 194 */       locateNext();
/*     */     }
/*     */     private void locateNext() {
/* 197 */       this.next = null;
/*     */       
/* 199 */       while (this.parent.hasNext() && this.next == null) {
/* 200 */         Entry entry = this.parent.next();
/* 201 */         if (!FilteringDirectoryNode.this.excludes.contains(entry.getName())) {
/* 202 */           this.next = FilteringDirectoryNode.this.wrapEntry(entry);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 208 */       return (this.next != null);
/*     */     }
/*     */     
/*     */     public Entry next() {
/* 212 */       Entry entry = this.next;
/* 213 */       locateNext();
/* 214 */       return entry;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 218 */       throw new UnsupportedOperationException("Remove not supported");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\FilteringDirectoryNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */