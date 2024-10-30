/*     */ package oshi.software.os;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import oshi.annotation.concurrent.Immutable;
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
/*     */ @Immutable
/*     */ public class OSDesktopWindow
/*     */ {
/*     */   private final long windowId;
/*     */   private final String title;
/*     */   private final String command;
/*     */   private final Rectangle locAndSize;
/*     */   private final long owningProcessId;
/*     */   private final int order;
/*     */   private final boolean visible;
/*     */   
/*     */   public OSDesktopWindow(long paramLong1, String paramString1, String paramString2, Rectangle paramRectangle, long paramLong2, int paramInt, boolean paramBoolean) {
/*  49 */     this.windowId = paramLong1;
/*  50 */     this.title = paramString1;
/*  51 */     this.command = paramString2;
/*  52 */     this.locAndSize = paramRectangle;
/*  53 */     this.owningProcessId = paramLong2;
/*  54 */     this.order = paramInt;
/*  55 */     this.visible = paramBoolean;
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
/*     */   public long getWindowId() {
/*  69 */     return this.windowId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  78 */     return this.title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommand() {
/*  88 */     return this.command;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getLocAndSize() {
/*  97 */     return this.locAndSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOwningProcessId() {
/* 106 */     return this.owningProcessId;
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
/*     */   public int getOrder() {
/* 125 */     return this.order;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 136 */     return this.visible;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     return "OSDesktopWindow [windowId=" + this.windowId + ", title=" + this.title + ", command=" + this.command + ", locAndSize=" + this.locAndSize
/* 142 */       .toString() + ", owningProcessId=" + this.owningProcessId + ", order=" + this.order + ", visible=" + this.visible + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\OSDesktopWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */