/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.GraphicsEnvironment;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.Properties;
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
/*    */ public class FontMetricsDumper
/*    */ {
/*    */   @SuppressForbidden("command line tool")
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 36 */     Properties properties = new Properties();
/*    */     
/* 38 */     Font[] arrayOfFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
/* 39 */     for (byte b = 0; b < arrayOfFont.length; b++) {
/*    */       
/* 41 */       String str = arrayOfFont[b].getFontName();
/*    */       
/* 43 */       Font font = new Font(str, 1, 10);
/* 44 */       FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
/* 45 */       int i = fontMetrics.getHeight();
/*    */       
/* 47 */       properties.setProperty("font." + str + ".height", i + "");
/* 48 */       StringBuffer stringBuffer1 = new StringBuffer(); char c1;
/* 49 */       for (c1 = 'a'; c1 <= 'z'; c1 = (char)(c1 + 1))
/*    */       {
/* 51 */         stringBuffer1.append(c1 + ", ");
/*    */       }
/* 53 */       for (c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + 1))
/*    */       {
/* 55 */         stringBuffer1.append(c1 + ", ");
/*    */       }
/* 57 */       for (c1 = '0'; c1 <= '9'; c1 = (char)(c1 + 1))
/*    */       {
/* 59 */         stringBuffer1.append(c1 + ", ");
/*    */       }
/* 61 */       StringBuffer stringBuffer2 = new StringBuffer(); char c2;
/* 62 */       for (c2 = 'a'; c2 <= 'z'; c2 = (char)(c2 + 1))
/*    */       {
/* 64 */         stringBuffer2.append(fontMetrics.getWidths()[c2] + ", ");
/*    */       }
/* 66 */       for (c2 = 'A'; c2 <= 'Z'; c2 = (char)(c2 + 1))
/*    */       {
/* 68 */         stringBuffer2.append(fontMetrics.getWidths()[c2] + ", ");
/*    */       }
/* 70 */       for (c2 = '0'; c2 <= '9'; c2 = (char)(c2 + 1))
/*    */       {
/* 72 */         stringBuffer2.append(fontMetrics.getWidths()[c2] + ", ");
/*    */       }
/* 74 */       properties.setProperty("font." + str + ".characters", stringBuffer1.toString());
/* 75 */       properties.setProperty("font." + str + ".widths", stringBuffer2.toString());
/*    */     } 
/*    */     
/* 78 */     FileOutputStream fileOutputStream = new FileOutputStream("font_metrics.properties");
/*    */     
/*    */     try {
/* 81 */       properties.store(fileOutputStream, "Font Metrics");
/*    */     }
/*    */     finally {
/*    */       
/* 85 */       fileOutputStream.close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\FontMetricsDumper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */