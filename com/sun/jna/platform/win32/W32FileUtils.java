/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.platform.FileUtils;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
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
/*    */ public class W32FileUtils
/*    */   extends FileUtils
/*    */ {
/*    */   public boolean hasTrash() {
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void moveToTrash(File... paramVarArgs) throws IOException {
/* 40 */     Shell32 shell32 = Shell32.INSTANCE;
/* 41 */     ShellAPI.SHFILEOPSTRUCT sHFILEOPSTRUCT = new ShellAPI.SHFILEOPSTRUCT();
/* 42 */     sHFILEOPSTRUCT.wFunc = 3;
/* 43 */     String[] arrayOfString = new String[paramVarArgs.length]; int i;
/* 44 */     for (i = 0; i < arrayOfString.length; i++) {
/* 45 */       arrayOfString[i] = paramVarArgs[i].getAbsolutePath();
/*    */     }
/* 47 */     sHFILEOPSTRUCT.pFrom = sHFILEOPSTRUCT.encodePaths(arrayOfString);
/* 48 */     sHFILEOPSTRUCT.fFlags = 1620;
/* 49 */     i = shell32.SHFileOperation(sHFILEOPSTRUCT);
/* 50 */     if (i != 0) {
/* 51 */       throw new IOException("Move to trash failed: " + sHFILEOPSTRUCT.pFrom + ": " + 
/* 52 */           Kernel32Util.formatMessageFromLastErrorCode(i));
/*    */     }
/* 54 */     if (sHFILEOPSTRUCT.fAnyOperationsAborted)
/* 55 */       throw new IOException("Move to trash aborted"); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\W32FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */