/*    */ package repackage;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.Reader;
/*    */ import java.io.StringReader;
/*    */ import java.io.StringWriter;
/*    */ import java.io.Writer;
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
/*    */ public class EditBuildScript
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 29 */     if (paramArrayOfString.length != 3) {
/* 30 */       throw new IllegalArgumentException("Wrong number of arguments");
/*    */     }
/* 32 */     paramArrayOfString[0] = paramArrayOfString[0].replace('/', File.separatorChar);
/*    */     
/* 34 */     File file = new File(paramArrayOfString[0]);
/*    */     
/* 36 */     StringBuffer stringBuffer = a(file);
/*    */     
/* 38 */     String str = "<property name=\"" + paramArrayOfString[1] + "\" value=\"";
/*    */     
/* 40 */     int i = stringBuffer.indexOf(str);
/*    */     
/* 42 */     if (i < 0) {
/* 43 */       throw new IllegalArgumentException("Can't find token: " + str);
/*    */     }
/* 45 */     int j = i + str.length();
/*    */     
/* 47 */     while (stringBuffer.charAt(j) != '"') {
/* 48 */       j++;
/*    */     }
/* 50 */     stringBuffer.replace(i + str.length(), j, paramArrayOfString[2]);
/*    */     
/* 52 */     a(file, stringBuffer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static StringBuffer a(File paramFile) throws IOException {
/* 58 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 59 */     InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/* 60 */     StringWriter stringWriter = new StringWriter();
/*    */     
/* 62 */     a(inputStreamReader, stringWriter);
/*    */     
/* 64 */     stringWriter.close();
/* 65 */     inputStreamReader.close();
/* 66 */     fileInputStream.close();
/*    */     
/* 68 */     return stringWriter.getBuffer();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static void a(File paramFile, StringBuffer paramStringBuffer) throws IOException {
/* 74 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/* 75 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
/* 76 */     StringReader stringReader = new StringReader(paramStringBuffer.toString());
/*    */     
/* 78 */     a(stringReader, outputStreamWriter);
/*    */     
/* 80 */     stringReader.close();
/* 81 */     outputStreamWriter.close();
/* 82 */     fileOutputStream.close();
/*    */   }
/*    */ 
/*    */   
/*    */   static void a(Reader paramReader, Writer paramWriter) throws IOException {
/* 87 */     char[] arrayOfChar = new char[16384];
/*    */ 
/*    */     
/*    */     while (true) {
/* 91 */       int i = paramReader.read(arrayOfChar, 0, arrayOfChar.length);
/*    */       
/* 93 */       if (i < 0) {
/*    */         break;
/*    */       }
/* 96 */       paramWriter.write(arrayOfChar, 0, i);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\repackage\EditBuildScript.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */