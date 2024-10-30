/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.Record;
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
/*     */ public final class WorkbookRecordList
/*     */   implements Iterable<Record>
/*     */ {
/*  27 */   private List<Record> records = new ArrayList<Record>();
/*     */   
/*  29 */   private int protpos = 0;
/*  30 */   private int bspos = 0;
/*  31 */   private int tabpos = 0;
/*  32 */   private int fontpos = 0;
/*  33 */   private int xfpos = 0;
/*  34 */   private int backuppos = 0;
/*  35 */   private int namepos = 0;
/*  36 */   private int supbookpos = 0;
/*  37 */   private int externsheetPos = 0;
/*  38 */   private int palettepos = -1;
/*     */ 
/*     */   
/*     */   public void setRecords(List<Record> paramList) {
/*  42 */     this.records = paramList;
/*     */   }
/*     */   
/*     */   public int size() {
/*  46 */     return this.records.size();
/*     */   }
/*     */   
/*     */   public Record get(int paramInt) {
/*  50 */     return this.records.get(paramInt);
/*     */   }
/*     */   
/*     */   public void add(int paramInt, Record paramRecord) {
/*  54 */     this.records.add(paramInt, paramRecord);
/*  55 */     if (getProtpos() >= paramInt) setProtpos(this.protpos + 1); 
/*  56 */     if (getBspos() >= paramInt) setBspos(this.bspos + 1); 
/*  57 */     if (getTabpos() >= paramInt) setTabpos(this.tabpos + 1); 
/*  58 */     if (getFontpos() >= paramInt) setFontpos(this.fontpos + 1); 
/*  59 */     if (getXfpos() >= paramInt) setXfpos(this.xfpos + 1); 
/*  60 */     if (getBackuppos() >= paramInt) setBackuppos(this.backuppos + 1); 
/*  61 */     if (getNamepos() >= paramInt) setNamepos(this.namepos + 1); 
/*  62 */     if (getSupbookpos() >= paramInt) setSupbookpos(this.supbookpos + 1); 
/*  63 */     if (getPalettepos() != -1 && getPalettepos() >= paramInt) setPalettepos(this.palettepos + 1); 
/*  64 */     if (getExternsheetPos() >= paramInt) setExternsheetPos(getExternsheetPos() + 1); 
/*     */   }
/*     */   
/*     */   public List<Record> getRecords() {
/*  68 */     return this.records;
/*     */   }
/*     */   
/*     */   public Iterator<Record> iterator() {
/*  72 */     return this.records.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Object paramObject) {
/*  82 */     byte b = 0;
/*  83 */     for (Record record : this.records) {
/*  84 */       if (record == paramObject) {
/*  85 */         remove(b);
/*     */         break;
/*     */       } 
/*  88 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/*  94 */     this.records.remove(paramInt);
/*  95 */     if (getProtpos() >= paramInt) setProtpos(this.protpos - 1); 
/*  96 */     if (getBspos() >= paramInt) setBspos(this.bspos - 1); 
/*  97 */     if (getTabpos() >= paramInt) setTabpos(this.tabpos - 1); 
/*  98 */     if (getFontpos() >= paramInt) setFontpos(this.fontpos - 1); 
/*  99 */     if (getXfpos() >= paramInt) setXfpos(this.xfpos - 1); 
/* 100 */     if (getBackuppos() >= paramInt) setBackuppos(this.backuppos - 1); 
/* 101 */     if (getNamepos() >= paramInt) setNamepos(getNamepos() - 1); 
/* 102 */     if (getSupbookpos() >= paramInt) setSupbookpos(getSupbookpos() - 1); 
/* 103 */     if (getPalettepos() != -1 && getPalettepos() >= paramInt) setPalettepos(this.palettepos - 1); 
/* 104 */     if (getExternsheetPos() >= paramInt) setExternsheetPos(getExternsheetPos() - 1); 
/*     */   }
/*     */   
/*     */   public int getProtpos() {
/* 108 */     return this.protpos;
/*     */   }
/*     */   
/*     */   public void setProtpos(int paramInt) {
/* 112 */     this.protpos = paramInt;
/*     */   }
/*     */   
/*     */   public int getBspos() {
/* 116 */     return this.bspos;
/*     */   }
/*     */   
/*     */   public void setBspos(int paramInt) {
/* 120 */     this.bspos = paramInt;
/*     */   }
/*     */   
/*     */   public int getTabpos() {
/* 124 */     return this.tabpos;
/*     */   }
/*     */   
/*     */   public void setTabpos(int paramInt) {
/* 128 */     this.tabpos = paramInt;
/*     */   }
/*     */   
/*     */   public int getFontpos() {
/* 132 */     return this.fontpos;
/*     */   }
/*     */   
/*     */   public void setFontpos(int paramInt) {
/* 136 */     this.fontpos = paramInt;
/*     */   }
/*     */   
/*     */   public int getXfpos() {
/* 140 */     return this.xfpos;
/*     */   }
/*     */   
/*     */   public void setXfpos(int paramInt) {
/* 144 */     this.xfpos = paramInt;
/*     */   }
/*     */   
/*     */   public int getBackuppos() {
/* 148 */     return this.backuppos;
/*     */   }
/*     */   
/*     */   public void setBackuppos(int paramInt) {
/* 152 */     this.backuppos = paramInt;
/*     */   }
/*     */   
/*     */   public int getPalettepos() {
/* 156 */     return this.palettepos;
/*     */   }
/*     */   
/*     */   public void setPalettepos(int paramInt) {
/* 160 */     this.palettepos = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNamepos() {
/* 169 */     return this.namepos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSupbookpos() {
/* 177 */     return this.supbookpos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamepos(int paramInt) {
/* 185 */     this.namepos = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSupbookpos(int paramInt) {
/* 193 */     this.supbookpos = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExternsheetPos() {
/* 201 */     return this.externsheetPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternsheetPos(int paramInt) {
/* 209 */     this.externsheetPos = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\WorkbookRecordList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */