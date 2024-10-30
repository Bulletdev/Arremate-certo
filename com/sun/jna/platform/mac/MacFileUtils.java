/*    */ package com.sun.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.platform.FileUtils;
/*    */ import com.sun.jna.ptr.ByteByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
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
/*    */ public class MacFileUtils
/*    */   extends FileUtils
/*    */ {
/*    */   public boolean hasTrash() {
/* 41 */     return true;
/*    */   }
/*    */   public static interface FileManager extends Library { public static final int kFSFileOperationDefaultOptions = 0; public static final int kFSFileOperationsOverwrite = 1;
/*    */     public static final int kFSFileOperationsSkipSourcePermissionErrors = 2;
/* 45 */     public static final FileManager INSTANCE = (FileManager)Native.load("CoreServices", FileManager.class); public static final int kFSFileOperationsDoNotMoveAcrossVolumes = 4; public static final int kFSFileOperationsSkipPreflight = 8; public static final int kFSPathDefaultOptions = 0; public static final int kFSPathMakeRefDoNotFollowLeafSymlink = 1;
/*    */     
/*    */     int FSRefMakePath(FSRef param1FSRef, byte[] param1ArrayOfbyte, int param1Int);
/*    */     
/*    */     int FSPathMakeRef(String param1String, int param1Int, ByteByReference param1ByteByReference);
/*    */     
/*    */     int FSPathMakeRefWithOptions(String param1String, int param1Int, FSRef param1FSRef, ByteByReference param1ByteByReference);
/*    */     
/*    */     int FSPathMoveObjectToTrashSync(String param1String, PointerByReference param1PointerByReference, int param1Int);
/*    */     
/*    */     int FSMoveObjectToTrashSync(FSRef param1FSRef1, FSRef param1FSRef2, int param1Int);
/*    */     
/*    */     @FieldOrder({"hidden"})
/* 58 */     public static class FSRef extends Structure { public byte[] hidden = new byte[80]; } } @FieldOrder({"hidden"}) public static class FSRef extends Structure { public byte[] hidden = new byte[80]; }
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
/*    */   public void moveToTrash(File... paramVarArgs) throws IOException {
/* 72 */     ArrayList<String> arrayList = new ArrayList();
/* 73 */     for (File file : paramVarArgs) {
/* 74 */       FileManager.FSRef fSRef = new FileManager.FSRef();
/* 75 */       int i = FileManager.INSTANCE.FSPathMakeRefWithOptions(file.getAbsolutePath(), 1, fSRef, null);
/*    */ 
/*    */       
/* 78 */       if (i != 0) {
/* 79 */         arrayList.add(file + " (FSRef: " + i + ")");
/*    */       } else {
/*    */         
/* 82 */         i = FileManager.INSTANCE.FSMoveObjectToTrashSync(fSRef, null, 0);
/* 83 */         if (i != 0)
/* 84 */           arrayList.add(file + " (" + i + ")"); 
/*    */       } 
/*    */     } 
/* 87 */     if (arrayList.size() > 0)
/* 88 */       throw new IOException("The following files could not be trashed: " + arrayList); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\MacFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */