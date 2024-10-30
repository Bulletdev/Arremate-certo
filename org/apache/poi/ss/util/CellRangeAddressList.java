/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CellRangeAddressList
/*     */ {
/*  48 */   protected final List<CellRangeAddress> _list = new ArrayList<CellRangeAddress>();
/*     */ 
/*     */   
/*     */   public CellRangeAddressList() {}
/*     */ 
/*     */   
/*     */   public CellRangeAddressList(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  55 */     this();
/*  56 */     addCellRangeAddress(paramInt1, paramInt3, paramInt2, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddressList(RecordInputStream paramRecordInputStream) {
/*  62 */     this();
/*  63 */     int i = paramRecordInputStream.readUShort();
/*     */     
/*  65 */     for (byte b = 0; b < i; b++) {
/*  66 */       this._list.add(new CellRangeAddress(paramRecordInputStream));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countRanges() {
/*  78 */     return this._list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCellRangeAddress(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  90 */     CellRangeAddress cellRangeAddress = new CellRangeAddress(paramInt1, paramInt3, paramInt2, paramInt4);
/*  91 */     addCellRangeAddress(cellRangeAddress);
/*     */   }
/*     */   public void addCellRangeAddress(CellRangeAddress paramCellRangeAddress) {
/*  94 */     this._list.add(paramCellRangeAddress);
/*     */   }
/*     */   public CellRangeAddress remove(int paramInt) {
/*  97 */     if (this._list.isEmpty()) {
/*  98 */       throw new RuntimeException("List is empty");
/*     */     }
/* 100 */     if (paramInt < 0 || paramInt >= this._list.size()) {
/* 101 */       throw new RuntimeException("Range index (" + paramInt + ") is outside allowable range (0.." + (this._list.size() - 1) + ")");
/*     */     }
/*     */     
/* 104 */     return this._list.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress getCellRangeAddress(int paramInt) {
/* 111 */     return this._list.get(paramInt);
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 115 */     return getEncodedSize(this._list.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getEncodedSize(int paramInt) {
/* 122 */     return 2 + CellRangeAddress.getEncodedSize(paramInt);
/*     */   }
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 126 */     int i = getSize();
/* 127 */     serialize((LittleEndianOutput)new LittleEndianByteArrayOutputStream(paramArrayOfbyte, paramInt, i));
/* 128 */     return i;
/*     */   }
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 131 */     int i = this._list.size();
/* 132 */     paramLittleEndianOutput.writeShort(i);
/* 133 */     for (byte b = 0; b < i; b++) {
/* 134 */       CellRangeAddress cellRangeAddress = this._list.get(b);
/* 135 */       cellRangeAddress.serialize(paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CellRangeAddressList copy() {
/* 141 */     CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
/*     */     
/* 143 */     int i = this._list.size();
/* 144 */     for (byte b = 0; b < i; b++) {
/* 145 */       CellRangeAddress cellRangeAddress = this._list.get(b);
/* 146 */       cellRangeAddressList.addCellRangeAddress(cellRangeAddress.copy());
/*     */     } 
/* 148 */     return cellRangeAddressList;
/*     */   }
/*     */   public CellRangeAddress[] getCellRangeAddresses() {
/* 151 */     CellRangeAddress[] arrayOfCellRangeAddress = new CellRangeAddress[this._list.size()];
/* 152 */     this._list.toArray(arrayOfCellRangeAddress);
/* 153 */     return arrayOfCellRangeAddress;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellRangeAddressList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */