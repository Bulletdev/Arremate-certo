/*     */ package com.sun.jna.platform.dnd;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.dnd.DragGestureEvent;
/*     */ import java.awt.dnd.DragGestureListener;
/*     */ import java.awt.dnd.DragSource;
/*     */ import java.awt.dnd.DragSourceContext;
/*     */ import java.awt.dnd.DragSourceDragEvent;
/*     */ import java.awt.dnd.DragSourceDropEvent;
/*     */ import java.awt.dnd.DragSourceEvent;
/*     */ import java.awt.dnd.DragSourceListener;
/*     */ import java.awt.dnd.DragSourceMotionListener;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.InvalidDnDOperationException;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JColorChooser;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.text.JTextComponent;
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
/*     */ public abstract class DragHandler
/*     */   implements DragGestureListener, DragSourceListener, DragSourceMotionListener
/*     */ {
/* 116 */   private static final Logger LOG = Logger.getLogger(DragHandler.class.getName());
/*     */ 
/*     */   
/* 119 */   public static final Dimension MAX_GHOST_SIZE = new Dimension(250, 250);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final float DEFAULT_GHOST_ALPHA = 0.5F;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int UNKNOWN_MODIFIERS = -1;
/*     */ 
/*     */ 
/*     */   
/* 132 */   public static final Transferable UNKNOWN_TRANSFERABLE = null;
/*     */ 
/*     */   
/*     */   protected static final int MOVE = 2;
/*     */ 
/*     */   
/*     */   protected static final int COPY = 1;
/*     */   
/*     */   protected static final int LINK = 1073741824;
/*     */   
/*     */   protected static final int NONE = 0;
/*     */   
/*     */   static final int MOVE_MASK = 64;
/*     */   
/* 146 */   static final boolean OSX = Platform.isMac();
/*     */   
/* 148 */   static final int COPY_MASK = OSX ? 512 : 128;
/*     */ 
/*     */   
/* 151 */   static final int LINK_MASK = OSX ? 768 : 192;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int KEY_MASK = 9152;
/*     */ 
/*     */ 
/*     */   
/* 160 */   private static int modifiers = -1;
/* 161 */   private static Transferable transferable = UNKNOWN_TRANSFERABLE;
/*     */ 
/*     */ 
/*     */   
/*     */   private int supportedActions;
/*     */ 
/*     */ 
/*     */   
/*     */   static int getModifiers() {
/* 170 */     return modifiers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transferable getTransferable(DropTargetEvent paramDropTargetEvent) {
/* 180 */     if (paramDropTargetEvent instanceof DropTargetDragEvent) {
/*     */       try {
/* 182 */         return ((DropTargetDragEvent)paramDropTargetEvent).getTransferable();
/* 183 */       } catch (Exception exception) {}
/*     */     
/*     */     }
/* 186 */     else if (paramDropTargetEvent instanceof DropTargetDropEvent) {
/* 187 */       return ((DropTargetDropEvent)paramDropTargetEvent).getTransferable();
/*     */     } 
/* 189 */     return transferable;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean fixCursor = true;
/*     */   private Component dragSource;
/*     */   private GhostedDragImage ghost;
/*     */   private Point imageOffset;
/* 197 */   private Dimension maxGhostSize = MAX_GHOST_SIZE;
/* 198 */   private float ghostAlpha = 0.5F;
/*     */   
/*     */   private String lastAction;
/*     */   
/*     */   private boolean moved;
/*     */ 
/*     */   
/*     */   protected DragHandler(Component paramComponent, int paramInt) {
/* 206 */     this.dragSource = paramComponent;
/* 207 */     this.supportedActions = paramInt;
/*     */     try {
/* 209 */       String str1 = System.getProperty("DragHandler.alpha");
/* 210 */       if (str1 != null) {
/*     */         try {
/* 212 */           this.ghostAlpha = Float.parseFloat(str1);
/*     */         }
/* 214 */         catch (NumberFormatException numberFormatException) {}
/*     */       }
/* 216 */       String str2 = System.getProperty("DragHandler.maxDragImageSize");
/* 217 */       if (str2 != null) {
/* 218 */         String[] arrayOfString = str2.split("x");
/* 219 */         if (arrayOfString.length == 2) {
/*     */           try {
/* 221 */             this
/* 222 */               .maxGhostSize = new Dimension(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]));
/*     */           }
/* 224 */           catch (NumberFormatException numberFormatException) {}
/*     */         }
/*     */       }
/*     */     
/* 228 */     } catch (SecurityException securityException) {}
/*     */     
/* 230 */     disableSwingDragSupport(paramComponent);
/* 231 */     DragSource dragSource = DragSource.getDefaultDragSource();
/* 232 */     dragSource.createDefaultDragGestureRecognizer(paramComponent, this.supportedActions, this);
/*     */   }
/*     */   
/*     */   private void disableSwingDragSupport(Component paramComponent) {
/* 236 */     if (paramComponent instanceof JTree) {
/* 237 */       ((JTree)paramComponent).setDragEnabled(false);
/*     */     }
/* 239 */     else if (paramComponent instanceof JList) {
/* 240 */       ((JList)paramComponent).setDragEnabled(false);
/*     */     }
/* 242 */     else if (paramComponent instanceof JTable) {
/* 243 */       ((JTable)paramComponent).setDragEnabled(false);
/*     */     }
/* 245 */     else if (paramComponent instanceof JTextComponent) {
/* 246 */       ((JTextComponent)paramComponent).setDragEnabled(false);
/*     */     }
/* 248 */     else if (paramComponent instanceof JColorChooser) {
/* 249 */       ((JColorChooser)paramComponent).setDragEnabled(false);
/*     */     }
/* 251 */     else if (paramComponent instanceof JFileChooser) {
/* 252 */       ((JFileChooser)paramComponent).setDragEnabled(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDrag(DragGestureEvent paramDragGestureEvent) {
/* 263 */     int i = paramDragGestureEvent.getTriggerEvent().getModifiersEx() & 0x23C0;
/* 264 */     if (i == 64)
/* 265 */       return ((this.supportedActions & 0x2) != 0); 
/* 266 */     if (i == COPY_MASK)
/* 267 */       return ((this.supportedActions & 0x1) != 0); 
/* 268 */     if (i == LINK_MASK)
/* 269 */       return ((this.supportedActions & 0x40000000) != 0); 
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModifiers(int paramInt) {
/* 277 */     modifiers = paramInt;
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
/*     */   protected abstract Transferable getTransferable(DragGestureEvent paramDragGestureEvent);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Icon getDragIcon(DragGestureEvent paramDragGestureEvent, Point paramPoint) {
/* 299 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dragStarted(DragGestureEvent paramDragGestureEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dragGestureRecognized(DragGestureEvent paramDragGestureEvent) {
/* 314 */     if ((paramDragGestureEvent.getDragAction() & this.supportedActions) != 0 && 
/* 315 */       canDrag(paramDragGestureEvent)) {
/* 316 */       setModifiers(paramDragGestureEvent.getTriggerEvent().getModifiersEx() & 0x23C0);
/* 317 */       Transferable transferable = getTransferable(paramDragGestureEvent);
/* 318 */       if (transferable == null)
/*     */         return; 
/*     */       try {
/* 321 */         Point point1 = new Point(0, 0);
/* 322 */         Icon icon1 = getDragIcon(paramDragGestureEvent, point1);
/* 323 */         Point point2 = paramDragGestureEvent.getDragOrigin();
/*     */         
/* 325 */         this.imageOffset = new Point(point1.x - point2.x, point1.y - point2.y);
/*     */         
/* 327 */         Icon icon2 = scaleDragIcon(icon1, this.imageOffset);
/* 328 */         Cursor cursor = null;
/* 329 */         if (icon2 != null && DragSource.isDragImageSupported()) {
/* 330 */           GraphicsConfiguration graphicsConfiguration = paramDragGestureEvent.getComponent().getGraphicsConfiguration();
/* 331 */           paramDragGestureEvent.startDrag(cursor, createDragImage(graphicsConfiguration, icon2), this.imageOffset, transferable, this);
/*     */         }
/*     */         else {
/*     */           
/* 335 */           if (icon2 != null) {
/* 336 */             Point point3 = this.dragSource.getLocationOnScreen();
/* 337 */             point3.translate(point2.x, point2.y);
/* 338 */             Point point4 = new Point(-this.imageOffset.x, -this.imageOffset.y);
/* 339 */             this
/* 340 */               .ghost = new GhostedDragImage(this.dragSource, icon2, getImageLocation(point3), point4);
/* 341 */             this.ghost.setAlpha(this.ghostAlpha);
/*     */           } 
/* 343 */           paramDragGestureEvent.startDrag(cursor, transferable, this);
/*     */         } 
/* 345 */         dragStarted(paramDragGestureEvent);
/* 346 */         this.moved = false;
/* 347 */         paramDragGestureEvent.getDragSource().addDragSourceMotionListener(this);
/* 348 */         transferable = transferable;
/*     */       }
/* 350 */       catch (InvalidDnDOperationException invalidDnDOperationException) {
/* 351 */         if (this.ghost != null) {
/* 352 */           this.ghost.dispose();
/* 353 */           this.ghost = null;
/*     */         } 
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Icon scaleDragIcon(Icon paramIcon, Point paramPoint) {
/* 379 */     return paramIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Image createDragImage(GraphicsConfiguration paramGraphicsConfiguration, Icon paramIcon) {
/* 389 */     int i = paramIcon.getIconWidth();
/* 390 */     int j = paramIcon.getIconHeight();
/* 391 */     BufferedImage bufferedImage = paramGraphicsConfiguration.createCompatibleImage(i, j, 3);
/* 392 */     Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
/* 393 */     graphics2D.setComposite(AlphaComposite.Clear);
/* 394 */     graphics2D.fillRect(0, 0, i, j);
/*     */     
/* 396 */     graphics2D.setComposite(AlphaComposite.getInstance(2, this.ghostAlpha));
/* 397 */     paramIcon.paintIcon(this.dragSource, graphics2D, 0, 0);
/* 398 */     graphics2D.dispose();
/* 399 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   private int reduce(int paramInt) {
/* 404 */     if ((paramInt & 0x2) != 0 && paramInt != 2) {
/* 405 */       return 2;
/*     */     }
/* 407 */     if ((paramInt & 0x1) != 0 && paramInt != 1) {
/* 408 */       return 1;
/*     */     }
/* 410 */     return paramInt;
/*     */   }
/*     */   
/*     */   protected Cursor getCursorForAction(int paramInt) {
/* 414 */     switch (paramInt) {
/*     */       case 2:
/* 416 */         return DragSource.DefaultMoveDrop;
/*     */       case 1:
/* 418 */         return DragSource.DefaultCopyDrop;
/*     */       case 1073741824:
/* 420 */         return DragSource.DefaultLinkDrop;
/*     */     } 
/* 422 */     return DragSource.DefaultMoveNoDrop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getAcceptableDropAction(int paramInt) {
/* 431 */     return reduce(this.supportedActions & paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDropAction(DragSourceEvent paramDragSourceEvent) {
/* 439 */     if (paramDragSourceEvent instanceof DragSourceDragEvent) {
/* 440 */       DragSourceDragEvent dragSourceDragEvent = (DragSourceDragEvent)paramDragSourceEvent;
/* 441 */       return dragSourceDragEvent.getDropAction();
/*     */     } 
/* 443 */     if (paramDragSourceEvent instanceof DragSourceDropEvent) {
/* 444 */       return ((DragSourceDropEvent)paramDragSourceEvent).getDropAction();
/*     */     }
/* 446 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int adjustDropAction(DragSourceEvent paramDragSourceEvent) {
/* 455 */     int i = getDropAction(paramDragSourceEvent);
/* 456 */     if (paramDragSourceEvent instanceof DragSourceDragEvent) {
/* 457 */       DragSourceDragEvent dragSourceDragEvent = (DragSourceDragEvent)paramDragSourceEvent;
/* 458 */       if (i == 0) {
/* 459 */         int j = dragSourceDragEvent.getGestureModifiersEx() & 0x23C0;
/* 460 */         if (j == 0) {
/* 461 */           i = getAcceptableDropAction(dragSourceDragEvent.getTargetActions());
/*     */         }
/*     */       } 
/*     */     } 
/* 465 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateCursor(DragSourceEvent paramDragSourceEvent) {
/* 473 */     if (!this.fixCursor)
/*     */       return; 
/* 475 */     Cursor cursor = getCursorForAction(adjustDropAction(paramDragSourceEvent));
/* 476 */     paramDragSourceEvent.getDragSourceContext().setCursor(cursor);
/*     */   }
/*     */   
/*     */   static String actionString(int paramInt) {
/* 480 */     switch (paramInt) { case 2:
/* 481 */         return "MOVE";
/* 482 */       case 3: return "MOVE|COPY";
/* 483 */       case 1073741826: return "MOVE|LINK";
/* 484 */       case 1073741827: return "MOVE|COPY|LINK";
/* 485 */       case 1: return "COPY";
/* 486 */       case 1073741825: return "COPY|LINK";
/* 487 */       case 1073741824: return "LINK"; }
/* 488 */      return "NONE";
/*     */   }
/*     */ 
/*     */   
/*     */   private void describe(String paramString, DragSourceEvent paramDragSourceEvent) {
/* 493 */     if (LOG.isLoggable(Level.FINE)) {
/* 494 */       StringBuilder stringBuilder = new StringBuilder();
/* 495 */       stringBuilder.append("drag: ");
/* 496 */       stringBuilder.append(paramString);
/* 497 */       DragSourceContext dragSourceContext = paramDragSourceEvent.getDragSourceContext();
/* 498 */       if (paramDragSourceEvent instanceof DragSourceDragEvent) {
/* 499 */         DragSourceDragEvent dragSourceDragEvent = (DragSourceDragEvent)paramDragSourceEvent;
/* 500 */         stringBuilder.append(": src=");
/* 501 */         stringBuilder.append(actionString(dragSourceContext.getSourceActions()));
/* 502 */         stringBuilder.append(" usr=");
/* 503 */         stringBuilder.append(actionString(dragSourceDragEvent.getUserAction()));
/* 504 */         stringBuilder.append(" tgt=");
/* 505 */         stringBuilder.append(actionString(dragSourceDragEvent.getTargetActions()));
/* 506 */         stringBuilder.append(" act=");
/* 507 */         stringBuilder.append(actionString(dragSourceDragEvent.getDropAction()));
/* 508 */         stringBuilder.append(" mods=");
/* 509 */         stringBuilder.append(dragSourceDragEvent.getGestureModifiersEx());
/*     */       } else {
/*     */         
/* 512 */         stringBuilder.append(": e=");
/* 513 */         stringBuilder.append(paramDragSourceEvent);
/*     */       } 
/* 515 */       String str = stringBuilder.toString();
/* 516 */       if (!str.equals(this.lastAction)) {
/* 517 */         LOG.log(Level.FINE, str);
/* 518 */         this.lastAction = str;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragDropEnd(DragSourceDropEvent paramDragSourceDropEvent) {
/* 525 */     describe("end", paramDragSourceDropEvent);
/* 526 */     setModifiers(-1);
/* 527 */     transferable = UNKNOWN_TRANSFERABLE;
/* 528 */     if (this.ghost != null) {
/* 529 */       if (paramDragSourceDropEvent.getDropSuccess()) {
/* 530 */         this.ghost.dispose();
/*     */       } else {
/*     */         
/* 533 */         this.ghost.returnToOrigin();
/*     */       } 
/* 535 */       this.ghost = null;
/*     */     } 
/* 537 */     DragSource dragSource = paramDragSourceDropEvent.getDragSourceContext().getDragSource();
/* 538 */     dragSource.removeDragSourceMotionListener(this);
/* 539 */     this.moved = false;
/*     */   }
/*     */   
/*     */   private Point getImageLocation(Point paramPoint) {
/* 543 */     paramPoint.translate(this.imageOffset.x, this.imageOffset.y);
/* 544 */     return paramPoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragEnter(DragSourceDragEvent paramDragSourceDragEvent) {
/* 549 */     describe("enter", paramDragSourceDragEvent);
/* 550 */     if (this.ghost != null) {
/* 551 */       this.ghost.move(getImageLocation(paramDragSourceDragEvent.getLocation()));
/*     */     }
/* 553 */     updateCursor(paramDragSourceDragEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dragMouseMoved(DragSourceDragEvent paramDragSourceDragEvent) {
/* 562 */     describe("move", paramDragSourceDragEvent);
/* 563 */     if (this.ghost != null) {
/* 564 */       this.ghost.move(getImageLocation(paramDragSourceDragEvent.getLocation()));
/*     */     }
/* 566 */     if (this.moved)
/* 567 */       updateCursor(paramDragSourceDragEvent); 
/* 568 */     this.moved = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragOver(DragSourceDragEvent paramDragSourceDragEvent) {
/* 573 */     describe("over", paramDragSourceDragEvent);
/* 574 */     if (this.ghost != null) {
/* 575 */       this.ghost.move(getImageLocation(paramDragSourceDragEvent.getLocation()));
/*     */     }
/* 577 */     updateCursor(paramDragSourceDragEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragExit(DragSourceEvent paramDragSourceEvent) {
/* 582 */     describe("exit", paramDragSourceEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropActionChanged(DragSourceDragEvent paramDragSourceDragEvent) {
/* 587 */     describe("change", paramDragSourceDragEvent);
/* 588 */     setModifiers(paramDragSourceDragEvent.getGestureModifiersEx() & 0x23C0);
/* 589 */     if (this.ghost != null) {
/* 590 */       this.ghost.move(getImageLocation(paramDragSourceDragEvent.getLocation()));
/*     */     }
/* 592 */     updateCursor(paramDragSourceDragEvent);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\dnd\DragHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */