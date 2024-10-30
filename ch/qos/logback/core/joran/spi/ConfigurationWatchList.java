/*    */ package ch.qos.logback.core.joran.spi;
/*    */ 
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ import java.io.File;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ConfigurationWatchList
/*    */   extends ContextAwareBase
/*    */ {
/*    */   URL mainURL;
/* 30 */   List<File> fileWatchList = new ArrayList<File>();
/* 31 */   List<Long> lastModifiedList = new ArrayList<Long>();
/*    */   
/*    */   public ConfigurationWatchList buildClone() {
/* 34 */     ConfigurationWatchList configurationWatchList = new ConfigurationWatchList();
/* 35 */     configurationWatchList.mainURL = this.mainURL;
/* 36 */     configurationWatchList.fileWatchList = new ArrayList<File>(this.fileWatchList);
/* 37 */     configurationWatchList.lastModifiedList = new ArrayList<Long>(this.lastModifiedList);
/* 38 */     return configurationWatchList;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 42 */     this.mainURL = null;
/* 43 */     this.lastModifiedList.clear();
/* 44 */     this.fileWatchList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMainURL(URL paramURL) {
/* 53 */     this.mainURL = paramURL;
/* 54 */     if (paramURL != null)
/* 55 */       addAsFileToWatch(paramURL); 
/*    */   }
/*    */   
/*    */   private void addAsFileToWatch(URL paramURL) {
/* 59 */     File file = convertToFile(paramURL);
/* 60 */     if (file != null) {
/* 61 */       this.fileWatchList.add(file);
/* 62 */       this.lastModifiedList.add(Long.valueOf(file.lastModified()));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void addToWatchList(URL paramURL) {
/* 67 */     addAsFileToWatch(paramURL);
/*    */   }
/*    */   
/*    */   public URL getMainURL() {
/* 71 */     return this.mainURL;
/*    */   }
/*    */   
/*    */   public List<File> getCopyOfFileWatchList() {
/* 75 */     return new ArrayList<File>(this.fileWatchList);
/*    */   }
/*    */   
/*    */   public boolean changeDetected() {
/* 79 */     int i = this.fileWatchList.size();
/* 80 */     for (byte b = 0; b < i; b++) {
/* 81 */       long l = ((Long)this.lastModifiedList.get(b)).longValue();
/* 82 */       File file = this.fileWatchList.get(b);
/* 83 */       if (l != file.lastModified()) {
/* 84 */         return true;
/*    */       }
/*    */     } 
/* 87 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   File convertToFile(URL paramURL) {
/* 93 */     String str = paramURL.getProtocol();
/* 94 */     if ("file".equals(str)) {
/* 95 */       return new File(URLDecoder.decode(paramURL.getFile()));
/*    */     }
/* 97 */     addInfo("URL [" + paramURL + "] is not of type file");
/* 98 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\ConfigurationWatchList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */