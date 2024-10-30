/*     */ package org.apache.poi.poifs.dev;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.property.DirectoryProperty;
/*     */ import org.apache.poi.poifs.property.Property;
/*     */ import org.apache.poi.poifs.property.PropertyTable;
/*     */ import org.apache.poi.poifs.storage.BlockAllocationTableReader;
/*     */ import org.apache.poi.poifs.storage.BlockList;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ import org.apache.poi.poifs.storage.ListManagedBlock;
/*     */ import org.apache.poi.poifs.storage.RawDataBlockList;
/*     */ import org.apache.poi.poifs.storage.SmallBlockTableReader;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.IntList;
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
/*     */ public class POIFSHeaderDumper
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  50 */     if (paramArrayOfString.length == 0) {
/*  51 */       System.err.println("Must specify at least one file to view");
/*  52 */       System.exit(1);
/*     */     } 
/*     */     
/*  55 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  56 */       viewFile(paramArrayOfString[b]);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void viewFile(String paramString) throws Exception {
/*  61 */     System.out.println("Dumping headers from: " + paramString);
/*  62 */     FileInputStream fileInputStream = new FileInputStream(paramString);
/*     */ 
/*     */     
/*  65 */     HeaderBlock headerBlock = new HeaderBlock(fileInputStream);
/*  66 */     displayHeader(headerBlock);
/*     */ 
/*     */     
/*  69 */     POIFSBigBlockSize pOIFSBigBlockSize = headerBlock.getBigBlockSize();
/*  70 */     RawDataBlockList rawDataBlockList = new RawDataBlockList(fileInputStream, pOIFSBigBlockSize);
/*  71 */     displayRawBlocksSummary(rawDataBlockList);
/*     */ 
/*     */     
/*  74 */     BlockAllocationTableReader blockAllocationTableReader1 = new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), (BlockList)rawDataBlockList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     displayBATReader("Big Blocks", blockAllocationTableReader1);
/*     */ 
/*     */     
/*  85 */     PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
/*     */ 
/*     */ 
/*     */     
/*  89 */     BlockAllocationTableReader blockAllocationTableReader2 = SmallBlockTableReader._getSmallDocumentBlockReader(pOIFSBigBlockSize, rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     displayBATReader("Small Blocks", blockAllocationTableReader2);
/*     */ 
/*     */     
/*  97 */     displayPropertiesSummary(propertyTable);
/*     */   }
/*     */   
/*     */   public static void displayHeader(HeaderBlock paramHeaderBlock) throws Exception {
/* 101 */     System.out.println("Header Details:");
/* 102 */     System.out.println(" Block size: " + paramHeaderBlock.getBigBlockSize().getBigBlockSize());
/* 103 */     System.out.println(" BAT (FAT) header blocks: " + (paramHeaderBlock.getBATArray()).length);
/* 104 */     System.out.println(" BAT (FAT) block count: " + paramHeaderBlock.getBATCount());
/* 105 */     if (paramHeaderBlock.getBATCount() > 0)
/* 106 */       System.out.println(" BAT (FAT) block 1 at: " + paramHeaderBlock.getBATArray()[0]); 
/* 107 */     System.out.println(" XBAT (FAT) block count: " + paramHeaderBlock.getXBATCount());
/* 108 */     System.out.println(" XBAT (FAT) block 1 at: " + paramHeaderBlock.getXBATIndex());
/* 109 */     System.out.println(" SBAT (MiniFAT) block count: " + paramHeaderBlock.getSBATCount());
/* 110 */     System.out.println(" SBAT (MiniFAT) block 1 at: " + paramHeaderBlock.getSBATStart());
/* 111 */     System.out.println(" Property table at: " + paramHeaderBlock.getPropertyStart());
/* 112 */     System.out.println("");
/*     */   }
/*     */   
/*     */   public static void displayRawBlocksSummary(RawDataBlockList paramRawDataBlockList) throws Exception {
/* 116 */     System.out.println("Raw Blocks Details:");
/* 117 */     System.out.println(" Number of blocks: " + paramRawDataBlockList.blockCount());
/*     */     
/* 119 */     for (byte b = 0; b < Math.min(16, paramRawDataBlockList.blockCount()); b++) {
/* 120 */       ListManagedBlock listManagedBlock = paramRawDataBlockList.get(b);
/* 121 */       byte[] arrayOfByte = new byte[Math.min(48, (listManagedBlock.getData()).length)];
/* 122 */       System.arraycopy(listManagedBlock.getData(), 0, arrayOfByte, 0, arrayOfByte.length);
/*     */       
/* 124 */       System.out.println(" Block #" + b + ":");
/* 125 */       System.out.println(HexDump.dump(arrayOfByte, 0L, 0));
/*     */     } 
/*     */     
/* 128 */     System.out.println("");
/*     */   }
/*     */   
/*     */   public static void displayBATReader(String paramString, BlockAllocationTableReader paramBlockAllocationTableReader) throws Exception {
/* 132 */     System.out.println("Sectors, as referenced from the " + paramString + " FAT:");
/* 133 */     IntList intList = paramBlockAllocationTableReader.getEntries();
/*     */     
/* 135 */     for (byte b = 0; b < intList.size(); b++) {
/* 136 */       int i = intList.get(b);
/* 137 */       String str = Integer.toString(i);
/* 138 */       if (i == -2) {
/* 139 */         str = "End Of Chain";
/* 140 */       } else if (i == -4) {
/* 141 */         str = "DI Fat Block";
/* 142 */       } else if (i == -3) {
/* 143 */         str = "Normal Fat Block";
/* 144 */       } else if (i == -1) {
/* 145 */         str = "Block Not Used (Free)";
/*     */       } 
/*     */       
/* 148 */       System.out.println("  Block  # " + b + " -> " + str);
/*     */     } 
/*     */     
/* 151 */     System.out.println("");
/*     */   }
/*     */   
/*     */   public static void displayPropertiesSummary(PropertyTable paramPropertyTable) {
/* 155 */     System.out.println("Mini Stream starts at " + paramPropertyTable.getRoot().getStartBlock());
/* 156 */     System.out.println("Mini Stream length is " + paramPropertyTable.getRoot().getSize());
/* 157 */     System.out.println();
/*     */     
/* 159 */     System.out.println("Properties and their block start:");
/* 160 */     displayProperties((DirectoryProperty)paramPropertyTable.getRoot(), "");
/* 161 */     System.out.println("");
/*     */   }
/*     */   public static void displayProperties(DirectoryProperty paramDirectoryProperty, String paramString) {
/* 164 */     String str = paramString + "  ";
/* 165 */     System.out.println(paramString + "-> " + paramDirectoryProperty.getName());
/* 166 */     for (Property property : paramDirectoryProperty) {
/* 167 */       if (property instanceof DirectoryProperty) {
/* 168 */         displayProperties((DirectoryProperty)property, str); continue;
/*     */       } 
/* 170 */       System.out.println(str + "=> " + property.getName());
/* 171 */       System.out.print(str + "   " + property.getSize() + " bytes in ");
/* 172 */       if (property.shouldUseSmallBlocks()) {
/* 173 */         System.out.print("mini");
/*     */       } else {
/* 175 */         System.out.print("main");
/*     */       } 
/* 177 */       System.out.println(" stream, starts at " + property.getStartBlock());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSHeaderDumper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */