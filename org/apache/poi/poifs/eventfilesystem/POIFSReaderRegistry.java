/*     */ package org.apache.poi.poifs.eventfilesystem;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.poifs.filesystem.DocumentDescriptor;
/*     */ import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class POIFSReaderRegistry
/*     */ {
/*  60 */   private Set<POIFSReaderListener> omnivorousListeners = new HashSet<POIFSReaderListener>();
/*  61 */   private Map<POIFSReaderListener, Set<DocumentDescriptor>> selectiveListeners = new HashMap<POIFSReaderListener, Set<DocumentDescriptor>>();
/*  62 */   private Map<DocumentDescriptor, Set<POIFSReaderListener>> chosenDocumentDescriptors = (Map<DocumentDescriptor, Set<POIFSReaderListener>>)new HashMap<DocumentDescriptor, Set<POIFSReaderListener>>();
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
/*     */   void registerListener(POIFSReaderListener paramPOIFSReaderListener, POIFSDocumentPath paramPOIFSDocumentPath, String paramString) {
/*  77 */     if (!this.omnivorousListeners.contains(paramPOIFSReaderListener)) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       Set<DocumentDescriptor> set = this.selectiveListeners.get(paramPOIFSReaderListener);
/*     */       
/*  84 */       if (set == null) {
/*     */ 
/*     */ 
/*     */         
/*  88 */         set = new HashSet();
/*  89 */         this.selectiveListeners.put(paramPOIFSReaderListener, set);
/*     */       } 
/*  91 */       DocumentDescriptor documentDescriptor = new DocumentDescriptor(paramPOIFSDocumentPath, paramString);
/*     */ 
/*     */       
/*  94 */       if (set.add(documentDescriptor)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 100 */         Set<POIFSReaderListener> set1 = this.chosenDocumentDescriptors.get(documentDescriptor);
/*     */ 
/*     */         
/* 103 */         if (set1 == null) {
/*     */ 
/*     */ 
/*     */           
/* 107 */           set1 = new HashSet();
/* 108 */           this.chosenDocumentDescriptors.put(documentDescriptor, set1);
/*     */         } 
/* 110 */         set1.add(paramPOIFSReaderListener);
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
/*     */   void registerListener(POIFSReaderListener paramPOIFSReaderListener) {
/* 123 */     if (!this.omnivorousListeners.contains(paramPOIFSReaderListener)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 130 */       removeSelectiveListener(paramPOIFSReaderListener);
/* 131 */       this.omnivorousListeners.add(paramPOIFSReaderListener);
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
/*     */   Iterator<POIFSReaderListener> getListeners(POIFSDocumentPath paramPOIFSDocumentPath, String paramString) {
/* 146 */     HashSet<POIFSReaderListener> hashSet = new HashSet<POIFSReaderListener>(this.omnivorousListeners);
/* 147 */     Set<? extends POIFSReaderListener> set = this.chosenDocumentDescriptors.get(new DocumentDescriptor(paramPOIFSDocumentPath, paramString));
/*     */ 
/*     */     
/* 150 */     if (set != null)
/*     */     {
/* 152 */       hashSet.addAll(set);
/*     */     }
/* 154 */     return hashSet.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeSelectiveListener(POIFSReaderListener paramPOIFSReaderListener) {
/* 159 */     Set set = this.selectiveListeners.remove(paramPOIFSReaderListener);
/*     */     
/* 161 */     if (set != null) {
/*     */       
/* 163 */       Iterator<DocumentDescriptor> iterator = set.iterator();
/*     */       
/* 165 */       while (iterator.hasNext())
/*     */       {
/* 167 */         dropDocument(paramPOIFSReaderListener, iterator.next());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropDocument(POIFSReaderListener paramPOIFSReaderListener, DocumentDescriptor paramDocumentDescriptor) {
/* 175 */     Set set = this.chosenDocumentDescriptors.get(paramDocumentDescriptor);
/*     */     
/* 177 */     set.remove(paramPOIFSReaderListener);
/* 178 */     if (set.size() == 0)
/*     */     {
/* 180 */       this.chosenDocumentDescriptors.remove(paramDocumentDescriptor);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\eventfilesystem\POIFSReaderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */