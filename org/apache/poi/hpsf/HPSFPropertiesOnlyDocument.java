/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.poi.POIDocument;
/*    */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*    */ import org.apache.poi.poifs.filesystem.EntryUtils;
/*    */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*    */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*    */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HPSFPropertiesOnlyDocument
/*    */   extends POIDocument
/*    */ {
/*    */   public HPSFPropertiesOnlyDocument(NPOIFSFileSystem paramNPOIFSFileSystem) {
/* 39 */     super(paramNPOIFSFileSystem.getRoot());
/*    */   }
/*    */   public HPSFPropertiesOnlyDocument(OPOIFSFileSystem paramOPOIFSFileSystem) {
/* 42 */     super(paramOPOIFSFileSystem);
/*    */   }
/*    */   public HPSFPropertiesOnlyDocument(POIFSFileSystem paramPOIFSFileSystem) {
/* 45 */     super(paramPOIFSFileSystem);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write() throws IOException {
/* 52 */     NPOIFSFileSystem nPOIFSFileSystem = this.directory.getFileSystem();
/*    */     
/* 54 */     validateInPlaceWritePossible();
/* 55 */     writeProperties(nPOIFSFileSystem, null);
/* 56 */     nPOIFSFileSystem.writeFilesystem();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(File paramFile) throws IOException {
/* 62 */     POIFSFileSystem pOIFSFileSystem = POIFSFileSystem.create(paramFile);
/*    */     try {
/* 64 */       write((NPOIFSFileSystem)pOIFSFileSystem);
/* 65 */       pOIFSFileSystem.writeFilesystem();
/*    */     } finally {
/* 67 */       pOIFSFileSystem.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(OutputStream paramOutputStream) throws IOException {
/* 74 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem();
/*    */     try {
/* 76 */       write(nPOIFSFileSystem);
/* 77 */       nPOIFSFileSystem.writeFilesystem(paramOutputStream);
/*    */     } finally {
/* 79 */       nPOIFSFileSystem.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void write(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 85 */     ArrayList arrayList = new ArrayList(2);
/*    */ 
/*    */     
/* 88 */     writeProperties(paramNPOIFSFileSystem, arrayList);
/*    */ 
/*    */     
/* 91 */     EntryUtils.copyNodes((DirectoryEntry)this.directory, (DirectoryEntry)paramNPOIFSFileSystem.getRoot(), arrayList);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\HPSFPropertiesOnlyDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */