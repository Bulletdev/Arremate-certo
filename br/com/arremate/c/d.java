/*     */ package br.com.arremate.c;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.MenuSelectionManager;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.PopupMenuEvent;
/*     */ import javax.swing.event.PopupMenuListener;
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*     */   private JPopupMenu a;
/*     */   private Component[] a;
/*     */   private b a;
/*     */   private b b;
/*  28 */   private final c a = new c();
/*     */   private int k;
/*     */   private int interval;
/*     */   private int l;
/*     */   private int o;
/*  33 */   private int p = 0;
/*  34 */   private int q = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(JMenu paramJMenu) {
/*  44 */     return new d(paramJMenu);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(JPopupMenu paramJPopupMenu) {
/*  55 */     return new d(paramJPopupMenu);
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
/*     */   public static d a(JMenu paramJMenu, int paramInt) {
/*  68 */     return new d(paramJMenu, paramInt);
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
/*     */   public static d a(JPopupMenu paramJPopupMenu, int paramInt) {
/*  81 */     return new d(paramJPopupMenu, paramInt);
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
/*     */   public static d a(JMenu paramJMenu, int paramInt1, int paramInt2) {
/*  95 */     return new d(paramJMenu, paramInt1, paramInt2);
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
/*     */   public static d a(JPopupMenu paramJPopupMenu, int paramInt1, int paramInt2) {
/* 109 */     return new d(paramJPopupMenu, paramInt1, paramInt2);
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
/*     */   public static d a(JMenu paramJMenu, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 129 */     return new d(paramJMenu, paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static d a(JPopupMenu paramJPopupMenu, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 150 */     return new d(paramJPopupMenu, paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public d(JMenu paramJMenu) {
/* 162 */     this(paramJMenu, 15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(JPopupMenu paramJPopupMenu) {
/* 173 */     this(paramJPopupMenu, 15);
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
/*     */   public d(JMenu paramJMenu, int paramInt) {
/* 186 */     this(paramJMenu, paramInt, 150);
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
/*     */   public d(JPopupMenu paramJPopupMenu, int paramInt) {
/* 199 */     this(paramJPopupMenu, paramInt, 150);
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
/*     */   public d(JMenu paramJMenu, int paramInt1, int paramInt2) {
/* 213 */     this(paramJMenu, paramInt1, paramInt2, 0, 0);
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
/*     */   public d(JPopupMenu paramJPopupMenu, int paramInt1, int paramInt2) {
/* 227 */     this(paramJPopupMenu, paramInt1, paramInt2, 0, 0);
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
/*     */   public d(JMenu paramJMenu, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 246 */     this(paramJMenu.getPopupMenu(), paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public d(JPopupMenu paramJPopupMenu, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 265 */     if (paramInt1 <= 0 || paramInt2 <= 0) {
/* 266 */       throw new IllegalArgumentException("scrollCount and interval must be greater than 0");
/*     */     }
/* 268 */     if (paramInt3 < 0 || paramInt4 < 0) {
/* 269 */       throw new IllegalArgumentException("topFixedCount and bottomFixedCount cannot be negative");
/*     */     }
/*     */     
/* 272 */     this.a = (c)new b(this, (a)a.a, -1);
/* 273 */     this.b = new b(this, a.b, 1);
/* 274 */     e(paramInt1);
/* 275 */     d(paramInt2);
/* 276 */     f(paramInt3);
/* 277 */     g(paramInt4);
/*     */     
/* 279 */     this.a = (c)paramJPopupMenu;
/* 280 */     paramJPopupMenu.addPopupMenuListener(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int d() {
/* 289 */     return this.interval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(int paramInt) {
/* 299 */     if (paramInt <= 0) {
/* 300 */       throw new IllegalArgumentException("interval must be greater than 0");
/*     */     }
/* 302 */     this.a.d(paramInt);
/* 303 */     this.b.d(paramInt);
/* 304 */     this.interval = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int e() {
/* 313 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(int paramInt) {
/* 323 */     if (paramInt <= 0) {
/* 324 */       throw new IllegalArgumentException("scrollCount must be greater than 0");
/*     */     }
/* 326 */     this.k = paramInt;
/* 327 */     MenuSelectionManager.defaultManager().clearSelectedPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int f() {
/* 336 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void f(int paramInt) {
/* 345 */     if (this.p <= paramInt) {
/* 346 */       this.p = paramInt;
/*     */     } else {
/* 348 */       this.p += paramInt - this.l;
/*     */     } 
/* 350 */     this.l = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int g() {
/* 359 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void g(int paramInt) {
/* 368 */     this.o = paramInt;
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
/*     */   public void a(JMenuItem paramJMenuItem) {
/* 380 */     if (paramJMenuItem == null) {
/* 381 */       this.q = -1;
/*     */     } else {
/* 383 */       int i = this.a.getComponentIndex(paramJMenuItem);
/* 384 */       this.q = i;
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
/*     */   public void h(int paramInt) {
/* 397 */     this.q = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 405 */     if (this.a != null) {
/* 406 */       this.a.removePopupMenuListener(this.a);
/* 407 */       this.a = null;
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
/*     */   public void finalize() throws Throwable {
/* 420 */     dispose();
/*     */   }
/*     */   
/*     */   private void h() {
/* 424 */     if (this.a != null && this.a.length > 0) {
/* 425 */       this.p = Math.max(this.l, this.p);
/* 426 */       this.p = Math.min(this.a.length - this.o - this.k, this.p);
/*     */       
/* 428 */       this.a.setEnabled((this.p > this.l));
/* 429 */       this.b.setEnabled((this.p + this.k < this.a.length - this.o));
/*     */       
/* 431 */       this.a.removeAll(); int i;
/* 432 */       for (i = 0; i < this.l; i++) {
/* 433 */         this.a.add((Component)this.a[i]);
/*     */       }
/* 435 */       if (this.l > 0) {
/* 436 */         this.a.addSeparator();
/*     */       }
/*     */       
/* 439 */       this.a.add((JMenuItem)this.a);
/* 440 */       for (i = this.p; i < this.k + this.p; i++) {
/* 441 */         this.a.add((Component)this.a[i]);
/*     */       }
/* 443 */       this.a.add(this.b);
/*     */       
/* 445 */       if (this.o > 0) {
/* 446 */         this.a.addSeparator();
/*     */       }
/* 448 */       for (i = this.a.length - this.o; i < this.a.length; i++) {
/* 449 */         this.a.add((Component)this.a[i]);
/*     */       }
/*     */       
/* 452 */       JComponent jComponent = (JComponent)this.a.getParent();
/* 453 */       jComponent.revalidate();
/* 454 */       jComponent.repaint();
/*     */     } 
/*     */   }
/*     */   
/*     */   private class c implements PopupMenuListener {
/*     */     private c(d this$0) {}
/*     */     
/*     */     public void popupMenuWillBecomeVisible(PopupMenuEvent param1PopupMenuEvent) {
/* 462 */       i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void popupMenuWillBecomeInvisible(PopupMenuEvent param1PopupMenuEvent) {
/* 467 */       j();
/*     */     }
/*     */ 
/*     */     
/*     */     public void popupMenuCanceled(PopupMenuEvent param1PopupMenuEvent) {
/* 472 */       j();
/*     */     }
/*     */     
/*     */     private void i() {
/* 476 */       d.a(this.a, d.a(this.a).getComponents());
/* 477 */       if (d.a(this.a) >= d.b(this.a) && 
/* 478 */         d.a(this.a) <= (d.a(this.a)).length - d.c(this.a) && (
/* 479 */         d.a(this.a) > d.d(this.a) + d.e(this.a) || 
/* 480 */         d.a(this.a) < d.d(this.a))) {
/* 481 */         d.a(this.a, Math.min(d.d(this.a), d.a(this.a)));
/* 482 */         d.a(this.a, Math.max(d.d(this.a), d.a(this.a) - d.e(this.a) + 1));
/*     */       } 
/* 484 */       if ((d.a(this.a)).length > d.b(this.a) + d.e(this.a) + d.c(this.a)) {
/* 485 */         d.a(this.a);
/*     */       }
/*     */     }
/*     */     
/*     */     private void j() {
/* 490 */       d.a(this.a).removeAll();
/* 491 */       for (Component component : d.a(this.a))
/* 492 */         d.a(this.a).add(component); 
/*     */     }
/*     */   }
/*     */   
/*     */   private class d
/*     */     extends Timer
/*     */   {
/*     */     public d(d this$0, int param1Int1, int param1Int2) {
/* 500 */       super(param1Int2, new ActionListener(this$0, param1Int1)
/*     */           {
/*     */             public void actionPerformed(ActionEvent param2ActionEvent)
/*     */             {
/* 504 */               d.a(this.b, d.d(this.b) + this.s);
/* 505 */               d.a(this.b);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   private class b
/*     */     extends JMenuItem
/*     */     implements ChangeListener {
/*     */     private d.d a;
/*     */     
/*     */     public b(d this$0, d.a param1a, int param1Int) {
/* 517 */       setIcon(param1a);
/* 518 */       setDisabledIcon(param1a);
/* 519 */       this.a = (d)new d.d(this$0, param1Int, d.f(this$0));
/* 520 */       addChangeListener(this);
/*     */     }
/*     */     
/*     */     public void d(int param1Int) {
/* 524 */       this.a.setDelay(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void stateChanged(ChangeEvent param1ChangeEvent) {
/* 529 */       if (isArmed() && !this.a.isRunning()) {
/* 530 */         this.a.start();
/*     */       }
/* 532 */       if (!isArmed() && this.a.isRunning())
/* 533 */         this.a.stop(); 
/*     */     }
/*     */   }
/*     */   
/*     */   private enum a
/*     */     implements Icon
/*     */   {
/* 540 */     a((String)new int[] { 9, 1, 9 }),
/* 541 */     b((String)new int[] { 1, 9, 1 });
/* 542 */     final int[] c = new int[] { 1, 5, 9 };
/*     */     final int[] d;
/*     */     
/*     */     a(int... param1VarArgs) {
/* 546 */       this.d = param1VarArgs;
/*     */     }
/*     */ 
/*     */     
/*     */     public void paintIcon(Component param1Component, Graphics param1Graphics, int param1Int1, int param1Int2) {
/* 551 */       Dimension dimension = param1Component.getSize();
/* 552 */       Graphics graphics = param1Graphics.create(dimension.width / 2 - 5, dimension.height / 2 - 5, 10, 10);
/* 553 */       graphics.setColor(Color.GRAY);
/* 554 */       graphics.drawPolygon(this.c, this.d, 3);
/* 555 */       if (param1Component.isEnabled()) {
/* 556 */         graphics.setColor(Color.BLACK);
/* 557 */         graphics.fillPolygon(this.c, this.d, 3);
/*     */       } 
/* 559 */       graphics.dispose();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIconWidth() {
/* 564 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIconHeight() {
/* 569 */       return 10;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */