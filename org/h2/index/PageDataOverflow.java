/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
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
/*     */ public class PageDataOverflow
/*     */   extends Page
/*     */ {
/*     */   static final int START_LAST = 9;
/*     */   static final int START_MORE = 11;
/*     */   private static final int START_NEXT_OVERFLOW = 7;
/*     */   private final PageStore store;
/*     */   private int type;
/*     */   private int parentPageId;
/*     */   private int nextPage;
/*     */   private final Data data;
/*     */   private int start;
/*     */   private int size;
/*     */   
/*     */   private PageDataOverflow(PageStore paramPageStore, int paramInt, Data paramData) {
/*  75 */     this.store = paramPageStore;
/*  76 */     setPos(paramInt);
/*  77 */     this.data = paramData;
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
/*     */   public static Page read(PageStore paramPageStore, Data paramData, int paramInt) {
/*  89 */     PageDataOverflow pageDataOverflow = new PageDataOverflow(paramPageStore, paramInt, paramData);
/*  90 */     pageDataOverflow.read();
/*  91 */     return pageDataOverflow;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static PageDataOverflow create(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Data paramData, int paramInt5, int paramInt6) {
/* 110 */     Data data = paramPageStore.createData();
/* 111 */     PageDataOverflow pageDataOverflow = new PageDataOverflow(paramPageStore, paramInt1, data);
/* 112 */     paramPageStore.logUndo(pageDataOverflow, null);
/* 113 */     data.writeByte((byte)paramInt2);
/* 114 */     data.writeShortInt(0);
/* 115 */     data.writeInt(paramInt3);
/* 116 */     if (paramInt2 == 3) {
/* 117 */       data.writeInt(paramInt4);
/*     */     } else {
/* 119 */       data.writeShortInt(paramInt6);
/*     */     } 
/* 121 */     pageDataOverflow.start = data.length();
/* 122 */     data.write(paramData.getBytes(), paramInt5, paramInt6);
/* 123 */     pageDataOverflow.type = paramInt2;
/* 124 */     pageDataOverflow.parentPageId = paramInt3;
/* 125 */     pageDataOverflow.nextPage = paramInt4;
/* 126 */     pageDataOverflow.size = paramInt6;
/* 127 */     return pageDataOverflow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void read() {
/* 134 */     this.data.reset();
/* 135 */     this.type = this.data.readByte();
/* 136 */     this.data.readShortInt();
/* 137 */     this.parentPageId = this.data.readInt();
/* 138 */     if (this.type == 19) {
/* 139 */       this.size = this.data.readShortInt();
/* 140 */       this.nextPage = 0;
/* 141 */     } else if (this.type == 3) {
/* 142 */       this.nextPage = this.data.readInt();
/* 143 */       this.size = this.store.getPageSize() - this.data.length();
/*     */     } else {
/* 145 */       throw DbException.get(90030, "page:" + getPos() + " type:" + this.type);
/*     */     } 
/*     */     
/* 148 */     this.start = this.data.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int readInto(Data paramData) {
/* 158 */     paramData.checkCapacity(this.size);
/* 159 */     if (this.type == 19) {
/* 160 */       paramData.write(this.data.getBytes(), 9, this.size);
/* 161 */       return 0;
/*     */     } 
/* 163 */     paramData.write(this.data.getBytes(), 11, this.size);
/* 164 */     return this.nextPage;
/*     */   }
/*     */   
/*     */   int getNextOverflow() {
/* 168 */     return this.nextPage;
/*     */   }
/*     */   
/*     */   private void writeHead() {
/* 172 */     this.data.writeByte((byte)this.type);
/* 173 */     this.data.writeShortInt(0);
/* 174 */     this.data.writeInt(this.parentPageId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 179 */     writeData();
/* 180 */     this.store.writePage(getPos(), this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeData() {
/* 185 */     this.data.reset();
/* 186 */     writeHead();
/* 187 */     if (this.type == 3) {
/* 188 */       this.data.writeInt(this.nextPage);
/*     */     } else {
/* 190 */       this.data.writeShortInt(this.size);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     return "page[" + getPos() + "] data leaf overflow parent:" + this.parentPageId + " next:" + this.nextPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 208 */     return 120 + this.store.getPageSize() >> 2;
/*     */   }
/*     */   
/*     */   void setParentPageId(int paramInt) {
/* 212 */     this.store.logUndo(this, this.data);
/* 213 */     this.parentPageId = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 220 */     Page page = this.store.getPage(this.parentPageId);
/* 221 */     if (page == null) {
/* 222 */       throw DbException.throwInternalError();
/*     */     }
/* 224 */     PageDataOverflow pageDataOverflow1 = null;
/* 225 */     if (this.nextPage != 0) {
/* 226 */       pageDataOverflow1 = (PageDataOverflow)this.store.getPage(this.nextPage);
/*     */     }
/* 228 */     this.store.logUndo(this, this.data);
/* 229 */     PageDataOverflow pageDataOverflow2 = create(this.store, paramInt, this.type, this.parentPageId, this.nextPage, this.data, this.start, this.size);
/*     */     
/* 231 */     this.store.update(pageDataOverflow2);
/* 232 */     if (pageDataOverflow1 != null) {
/* 233 */       pageDataOverflow1.setParentPageId(paramInt);
/* 234 */       this.store.update(pageDataOverflow1);
/*     */     } 
/* 236 */     if (page instanceof PageDataOverflow) {
/* 237 */       PageDataOverflow pageDataOverflow = (PageDataOverflow)page;
/* 238 */       pageDataOverflow.setNext(getPos(), paramInt);
/*     */     } else {
/* 240 */       PageDataLeaf pageDataLeaf = (PageDataLeaf)page;
/* 241 */       pageDataLeaf.setOverflow(getPos(), paramInt);
/*     */     } 
/* 243 */     this.store.update(page);
/* 244 */     this.store.free(getPos());
/*     */   }
/*     */   
/*     */   private void setNext(int paramInt1, int paramInt2) {
/* 248 */     if (SysProperties.CHECK && paramInt1 != this.nextPage) {
/* 249 */       DbException.throwInternalError("move " + this + " " + paramInt2);
/*     */     }
/* 251 */     this.store.logUndo(this, this.data);
/* 252 */     this.nextPage = paramInt2;
/* 253 */     this.data.setInt(7, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void free() {
/* 260 */     this.store.logUndo(this, this.data);
/* 261 */     this.store.free(getPos());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStream() {
/* 271 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDataOverflow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */