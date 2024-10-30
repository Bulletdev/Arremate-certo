/*    */ package org.apache.poi.poifs.common;
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
/*    */ public interface POIFSConstants
/*    */ {
/*    */   public static final int SMALLER_BIG_BLOCK_SIZE = 512;
/* 29 */   public static final POIFSBigBlockSize SMALLER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(512, (short)9);
/*    */   
/*    */   public static final int LARGER_BIG_BLOCK_SIZE = 4096;
/*    */   
/* 33 */   public static final POIFSBigBlockSize LARGER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(4096, (short)12);
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int SMALL_BLOCK_SIZE = 64;
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int PROPERTY_SIZE = 128;
/*    */ 
/*    */   
/*    */   public static final int BIG_BLOCK_MINIMUM_DOCUMENT_SIZE = 4096;
/*    */ 
/*    */   
/*    */   public static final int LARGEST_REGULAR_SECTOR_NUMBER = -5;
/*    */ 
/*    */   
/*    */   public static final int DIFAT_SECTOR_BLOCK = -4;
/*    */ 
/*    */   
/*    */   public static final int FAT_SECTOR_BLOCK = -3;
/*    */ 
/*    */   
/*    */   public static final int END_OF_CHAIN = -2;
/*    */ 
/*    */   
/*    */   public static final int UNUSED_BLOCK = -1;
/*    */ 
/*    */   
/* 62 */   public static final byte[] OOXML_FILE_HEADER = new byte[] { 80, 75, 3, 4 };
/*    */ 
/*    */   
/* 65 */   public static final byte[] RAW_XML_FILE_HEADER = new byte[] { 60, 63, 120, 109, 108 };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\common\POIFSConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */