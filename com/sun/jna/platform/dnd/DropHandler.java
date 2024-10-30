/*     */ package com.sun.jna.platform.dnd;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Point;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.dnd.DropTarget;
/*     */ import java.awt.dnd.DropTargetContext;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public abstract class DropHandler
/*     */   implements DropTargetListener
/*     */ {
/* 102 */   private static final Logger LOG = Logger.getLogger(DropHandler.class.getName());
/*     */   
/*     */   private int acceptedActions;
/*     */   
/*     */   private List<DataFlavor> acceptedFlavors;
/*     */   
/*     */   private DropTarget dropTarget;
/*     */   
/*     */   private boolean active = true;
/*     */   
/*     */   private DropTargetPainter painter;
/*     */   
/*     */   private String lastAction;
/*     */   
/*     */   public DropHandler(Component paramComponent, int paramInt) {
/* 117 */     this(paramComponent, paramInt, new DataFlavor[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DropHandler(Component paramComponent, int paramInt, DataFlavor[] paramArrayOfDataFlavor) {
/* 128 */     this(paramComponent, paramInt, paramArrayOfDataFlavor, null);
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
/*     */   public DropHandler(Component paramComponent, int paramInt, DataFlavor[] paramArrayOfDataFlavor, DropTargetPainter paramDropTargetPainter) {
/* 141 */     this.acceptedActions = paramInt;
/* 142 */     this.acceptedFlavors = Arrays.asList(paramArrayOfDataFlavor);
/* 143 */     this.painter = paramDropTargetPainter;
/* 144 */     this.dropTarget = new DropTarget(paramComponent, paramInt, this, this.active);
/*     */   }
/*     */   
/*     */   protected DropTarget getDropTarget() {
/* 148 */     return this.dropTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isActive() {
/* 154 */     return this.active;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActive(boolean paramBoolean) {
/* 161 */     this.active = paramBoolean;
/* 162 */     if (this.dropTarget != null) {
/* 163 */       this.dropTarget.setActive(paramBoolean);
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
/*     */ 
/*     */   
/*     */   protected int getDropActionsForFlavors(DataFlavor[] paramArrayOfDataFlavor) {
/* 177 */     return this.acceptedActions;
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
/*     */   protected int getDropAction(DropTargetEvent paramDropTargetEvent) {
/* 196 */     int i = 0;
/* 197 */     int j = 0;
/* 198 */     Point point = null;
/* 199 */     DataFlavor[] arrayOfDataFlavor = new DataFlavor[0];
/* 200 */     if (paramDropTargetEvent instanceof DropTargetDragEvent) {
/* 201 */       DropTargetDragEvent dropTargetDragEvent = (DropTargetDragEvent)paramDropTargetEvent;
/* 202 */       i = dropTargetDragEvent.getDropAction();
/* 203 */       j = dropTargetDragEvent.getSourceActions();
/* 204 */       arrayOfDataFlavor = dropTargetDragEvent.getCurrentDataFlavors();
/* 205 */       point = dropTargetDragEvent.getLocation();
/*     */     }
/* 207 */     else if (paramDropTargetEvent instanceof DropTargetDropEvent) {
/* 208 */       DropTargetDropEvent dropTargetDropEvent = (DropTargetDropEvent)paramDropTargetEvent;
/* 209 */       i = dropTargetDropEvent.getDropAction();
/* 210 */       j = dropTargetDropEvent.getSourceActions();
/* 211 */       arrayOfDataFlavor = dropTargetDropEvent.getCurrentDataFlavors();
/* 212 */       point = dropTargetDropEvent.getLocation();
/*     */     } 
/* 214 */     if (isSupported(arrayOfDataFlavor)) {
/* 215 */       int k = getDropActionsForFlavors(arrayOfDataFlavor);
/* 216 */       i = getDropAction(paramDropTargetEvent, i, j, k);
/* 217 */       if (i != 0 && 
/* 218 */         canDrop(paramDropTargetEvent, i, point)) {
/* 219 */         return i;
/*     */       }
/*     */     } 
/*     */     
/* 223 */     return 0;
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
/*     */ 
/*     */   
/*     */   protected int getDropAction(DropTargetEvent paramDropTargetEvent, int paramInt1, int paramInt2, int paramInt3) {
/* 244 */     boolean bool = modifiersActive(paramInt1);
/* 245 */     if ((paramInt1 & paramInt3) == 0 && !bool) {
/*     */       
/* 247 */       int i = paramInt3 & paramInt2;
/* 248 */       paramInt1 = i;
/*     */     }
/* 250 */     else if (bool) {
/* 251 */       int i = paramInt1 & paramInt3 & paramInt2;
/* 252 */       if (i != paramInt1) {
/* 253 */         paramInt1 = i;
/*     */       }
/*     */     } 
/* 256 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean modifiersActive(int paramInt) {
/* 267 */     int i = DragHandler.getModifiers();
/* 268 */     if (i == -1) {
/* 269 */       if (paramInt == 1073741824 || paramInt == 1)
/*     */       {
/* 271 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 275 */       return false;
/*     */     } 
/* 277 */     return (i != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void describe(String paramString, DropTargetEvent paramDropTargetEvent) {
/* 282 */     if (LOG.isLoggable(Level.FINE)) {
/* 283 */       StringBuilder stringBuilder = new StringBuilder();
/* 284 */       stringBuilder.append("drop: ");
/* 285 */       stringBuilder.append(paramString);
/* 286 */       if (paramDropTargetEvent instanceof DropTargetDragEvent) {
/* 287 */         DropTargetContext dropTargetContext = paramDropTargetEvent.getDropTargetContext();
/* 288 */         DropTarget dropTarget = dropTargetContext.getDropTarget();
/* 289 */         DropTargetDragEvent dropTargetDragEvent = (DropTargetDragEvent)paramDropTargetEvent;
/* 290 */         stringBuilder.append(": src=");
/* 291 */         stringBuilder.append(DragHandler.actionString(dropTargetDragEvent.getSourceActions()));
/* 292 */         stringBuilder.append(" tgt=");
/* 293 */         stringBuilder.append(DragHandler.actionString(dropTarget.getDefaultActions()));
/* 294 */         stringBuilder.append(" act=");
/* 295 */         stringBuilder.append(DragHandler.actionString(dropTargetDragEvent.getDropAction()));
/*     */       }
/* 297 */       else if (paramDropTargetEvent instanceof DropTargetDropEvent) {
/* 298 */         DropTargetContext dropTargetContext = paramDropTargetEvent.getDropTargetContext();
/* 299 */         DropTarget dropTarget = dropTargetContext.getDropTarget();
/* 300 */         DropTargetDropEvent dropTargetDropEvent = (DropTargetDropEvent)paramDropTargetEvent;
/* 301 */         stringBuilder.append(": src=");
/* 302 */         stringBuilder.append(DragHandler.actionString(dropTargetDropEvent.getSourceActions()));
/* 303 */         stringBuilder.append(" tgt=");
/* 304 */         stringBuilder.append(DragHandler.actionString(dropTarget.getDefaultActions()));
/* 305 */         stringBuilder.append(" act=");
/* 306 */         stringBuilder.append(DragHandler.actionString(dropTargetDropEvent.getDropAction()));
/*     */       } 
/* 308 */       String str = stringBuilder.toString();
/* 309 */       if (!str.equals(this.lastAction)) {
/* 310 */         LOG.log(Level.FINE, str);
/* 311 */         this.lastAction = str;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int acceptOrReject(DropTargetDragEvent paramDropTargetDragEvent) {
/* 322 */     int i = getDropAction(paramDropTargetDragEvent);
/* 323 */     if (i != 0) {
/*     */ 
/*     */       
/* 326 */       paramDropTargetDragEvent.acceptDrag(i);
/*     */     } else {
/*     */       
/* 329 */       paramDropTargetDragEvent.rejectDrag();
/*     */     } 
/* 331 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragEnter(DropTargetDragEvent paramDropTargetDragEvent) {
/* 336 */     describe("enter(tgt)", paramDropTargetDragEvent);
/* 337 */     int i = acceptOrReject(paramDropTargetDragEvent);
/* 338 */     paintDropTarget(paramDropTargetDragEvent, i, paramDropTargetDragEvent.getLocation());
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragOver(DropTargetDragEvent paramDropTargetDragEvent) {
/* 343 */     describe("over(tgt)", paramDropTargetDragEvent);
/* 344 */     int i = acceptOrReject(paramDropTargetDragEvent);
/* 345 */     paintDropTarget(paramDropTargetDragEvent, i, paramDropTargetDragEvent.getLocation());
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragExit(DropTargetEvent paramDropTargetEvent) {
/* 350 */     describe("exit(tgt)", paramDropTargetEvent);
/* 351 */     paintDropTarget(paramDropTargetEvent, 0, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropActionChanged(DropTargetDragEvent paramDropTargetDragEvent) {
/* 356 */     describe("change(tgt)", paramDropTargetDragEvent);
/* 357 */     int i = acceptOrReject(paramDropTargetDragEvent);
/* 358 */     paintDropTarget(paramDropTargetDragEvent, i, paramDropTargetDragEvent.getLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drop(DropTargetDropEvent paramDropTargetDropEvent) {
/* 367 */     describe("drop(tgt)", paramDropTargetDropEvent);
/* 368 */     int i = getDropAction(paramDropTargetDropEvent);
/* 369 */     if (i != 0) {
/* 370 */       paramDropTargetDropEvent.acceptDrop(i);
/*     */       try {
/* 372 */         drop(paramDropTargetDropEvent, i);
/*     */         
/* 374 */         paramDropTargetDropEvent.dropComplete(true);
/* 375 */       } catch (Exception exception) {
/* 376 */         paramDropTargetDropEvent.dropComplete(false);
/*     */       } 
/*     */     } else {
/* 379 */       paramDropTargetDropEvent.rejectDrop();
/*     */     } 
/* 381 */     paintDropTarget(paramDropTargetDropEvent, 0, paramDropTargetDropEvent.getLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSupported(DataFlavor[] paramArrayOfDataFlavor) {
/* 391 */     HashSet hashSet = new HashSet(Arrays.asList((Object[])paramArrayOfDataFlavor));
/* 392 */     hashSet.retainAll(this.acceptedFlavors);
/* 393 */     return !hashSet.isEmpty();
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
/*     */   protected void paintDropTarget(DropTargetEvent paramDropTargetEvent, int paramInt, Point paramPoint) {
/* 410 */     if (this.painter != null) {
/* 411 */       this.painter.paintDropTarget(paramDropTargetEvent, paramInt, paramPoint);
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDrop(DropTargetEvent paramDropTargetEvent, int paramInt, Point paramPoint) {
/* 426 */     return true;
/*     */   }
/*     */   
/*     */   protected abstract void drop(DropTargetDropEvent paramDropTargetDropEvent, int paramInt) throws UnsupportedFlavorException, IOException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\dnd\DropHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */