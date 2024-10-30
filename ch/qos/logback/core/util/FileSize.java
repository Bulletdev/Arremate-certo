/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileSize
/*    */ {
/*    */   private static final String LENGTH_PART = "([0-9]+)";
/*    */   private static final int DOUBLE_GROUP = 1;
/*    */   private static final String UNIT_PART = "(|kb|mb|gb)s?";
/*    */   private static final int UNIT_GROUP = 2;
/* 40 */   private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);
/*    */   
/*    */   public static final long KB_COEFFICIENT = 1024L;
/*    */   
/*    */   public static final long MB_COEFFICIENT = 1048576L;
/*    */   public static final long GB_COEFFICIENT = 1073741824L;
/*    */   final long size;
/*    */   
/*    */   public FileSize(long paramLong) {
/* 49 */     this.size = paramLong;
/*    */   }
/*    */   
/*    */   public long getSize() {
/* 53 */     return this.size;
/*    */   }
/*    */   
/*    */   public static FileSize valueOf(String paramString) {
/* 57 */     Matcher matcher = FILE_SIZE_PATTERN.matcher(paramString);
/*    */ 
/*    */     
/* 60 */     if (matcher.matches()) {
/* 61 */       long l1; String str1 = matcher.group(1);
/* 62 */       String str2 = matcher.group(2);
/*    */       
/* 64 */       long l2 = Long.valueOf(str1).longValue();
/* 65 */       if (str2.equalsIgnoreCase("")) {
/* 66 */         l1 = 1L;
/* 67 */       } else if (str2.equalsIgnoreCase("kb")) {
/* 68 */         l1 = 1024L;
/* 69 */       } else if (str2.equalsIgnoreCase("mb")) {
/* 70 */         l1 = 1048576L;
/* 71 */       } else if (str2.equalsIgnoreCase("gb")) {
/* 72 */         l1 = 1073741824L;
/*    */       } else {
/* 74 */         throw new IllegalStateException("Unexpected " + str2);
/*    */       } 
/* 76 */       return new FileSize(l2 * l1);
/*    */     } 
/* 78 */     throw new IllegalArgumentException("String value [" + paramString + "] is not in the expected format.");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 84 */     long l1 = this.size / 1024L;
/*    */     
/* 86 */     if (l1 == 0L) {
/* 87 */       return this.size + " Bytes";
/*    */     }
/* 89 */     long l2 = this.size / 1048576L;
/* 90 */     if (l2 == 0L) {
/* 91 */       return l1 + " KB";
/*    */     }
/*    */     
/* 94 */     long l3 = this.size / 1073741824L;
/* 95 */     if (l3 == 0L) {
/* 96 */       return l2 + " MB";
/*    */     }
/*    */     
/* 99 */     return l3 + " GB";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\FileSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */