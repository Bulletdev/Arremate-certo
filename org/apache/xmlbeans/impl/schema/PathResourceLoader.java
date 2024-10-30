/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.xmlbeans.ResourceLoader;
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
/*    */ public class PathResourceLoader
/*    */   implements ResourceLoader
/*    */ {
/*    */   private ResourceLoader[] _path;
/*    */   
/*    */   public PathResourceLoader(ResourceLoader[] paramArrayOfResourceLoader) throws IOException {
/* 32 */     this._path = new ResourceLoader[paramArrayOfResourceLoader.length];
/* 33 */     System.arraycopy(paramArrayOfResourceLoader, 0, this._path, 0, this._path.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public PathResourceLoader(File[] paramArrayOfFile) {
/* 38 */     ArrayList arrayList = new ArrayList();
/* 39 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/*    */ 
/*    */       
/*    */       try {
/* 43 */         FileResourceLoader fileResourceLoader = new FileResourceLoader(paramArrayOfFile[b]);
/* 44 */         arrayList.add(fileResourceLoader);
/*    */       }
/* 46 */       catch (IOException iOException) {}
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 51 */     this._path = arrayList.<ResourceLoader>toArray(new ResourceLoader[arrayList.size()]);
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getResourceAsStream(String paramString) {
/* 56 */     for (byte b = 0; b < this._path.length; b++) {
/*    */       
/* 58 */       InputStream inputStream = this._path[b].getResourceAsStream(paramString);
/* 59 */       if (inputStream != null)
/* 60 */         return inputStream; 
/*    */     } 
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 67 */     for (byte b = 0; b < this._path.length; b++) {
/*    */ 
/*    */       
/*    */       try {
/* 71 */         this._path[b].close();
/*    */       }
/* 73 */       catch (Exception exception) {}
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\PathResourceLoader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */