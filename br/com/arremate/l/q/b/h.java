/*     */ package br.com.arremate.l.q.b;
/*     */ 
/*     */ import br.com.arremate.i.a.b;
/*     */ import br.com.arremate.i.a.d;
/*     */ import br.com.arremate.i.b;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.q;
/*     */ import br.com.arremate.m.r;
/*     */ import br.com.arremate.m.v;
/*     */ import br.com.arremate.m.w;
/*     */ import br.com.arremate.m.x;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.RowFilter;
/*     */ import javax.swing.RowSorter;
/*     */ import javax.swing.SortOrder;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.table.JTableHeader;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import javax.swing.table.TableRowSorter;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */   extends JTable
/*     */ {
/*  68 */   private static final Logger a = LoggerFactory.getLogger(h.class);
/*     */   
/*     */   private final TableRowSorter<i> a;
/*     */   
/*     */   private int bQ;
/*     */   private int bR;
/*     */   private int bS;
/*     */   private int bT;
/*     */   private int bU;
/*     */   private int bV;
/*     */   private int bW;
/*     */   
/*     */   public h() {
/*  81 */     this(new i());
/*     */   }
/*     */   
/*     */   public h(i parami) {
/*  85 */     setModel(parami);
/*  86 */     this.a = new TableRowSorter<>(parami);
/*     */     
/*  88 */     cy();
/*  89 */     cD();
/*  90 */     l();
/*  91 */     cz();
/*  92 */     cE();
/*     */   }
/*     */   
/*     */   private void cy() {
/*  96 */     setRowHeight(19);
/*  97 */     setAutoCreateRowSorter(false);
/*  98 */     getTableHeader().setReorderingAllowed(false);
/*     */     
/* 100 */     if (SystemUtils.IS_OS_MAC) {
/* 101 */       Font font = getFont();
/* 102 */       font = new Font(font.getName(), font.getStyle(), font.getSize() - 1);
/* 103 */       setFont(font);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void l() {
/* 108 */     addMouseMotionListener(new MouseMotionAdapter(this)
/*     */         {
/*     */           public void mouseMoved(MouseEvent param1MouseEvent) {
/* 111 */             if (n.aE()) {
/* 112 */               int i = this.b.columnAtPoint(param1MouseEvent.getPoint());
/*     */               
/* 114 */               this.b.setCursor((i == 13) ? new Cursor(12) : new Cursor(0));
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     addComponentListener(new ComponentAdapter(this)
/*     */         {
/*     */           public void componentResized(ComponentEvent param1ComponentEvent) {
/* 125 */             if (this.b.getRowCount() <= 0) {
/* 126 */               h.c(this.b);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 131 */     addKeyListener(new KeyAdapter(this)
/*     */         {
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/* 134 */             if (param1KeyEvent.getKeyCode() != 113) {
/* 135 */               param1KeyEvent.consume();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cD() {
/* 147 */     ArrayList<RowSorter.SortKey> arrayList = new ArrayList();
/* 148 */     arrayList.add(new RowSorter.SortKey(17, SortOrder.ASCENDING));
/* 149 */     this.a.setSortKeys(arrayList);
/*     */     
/* 151 */     this.a.setSortable(0, false);
/* 152 */     this.a.setSortable(1, false);
/* 153 */     this.a.setSortable(2, false);
/* 154 */     this.a.setSortable(3, false);
/* 155 */     this.a.setSortable(4, false);
/* 156 */     this.a.setSortable(5, false);
/* 157 */     this.a.setSortable(6, false);
/* 158 */     this.a.setSortable(7, false);
/* 159 */     this.a.setSortable(8, false);
/* 160 */     this.a.setSortable(9, false);
/* 161 */     this.a.setSortable(11, false);
/* 162 */     this.a.setSortable(10, false);
/* 163 */     this.a.setSortable(12, false);
/* 164 */     this.a.setSortable(13, false);
/* 165 */     this.a.setSortable(15, false);
/* 166 */     this.a.setSortable(16, false);
/* 167 */     this.a.setSortable(14, false);
/* 168 */     this.a.setSortable(17, false);
/* 169 */     super.setRowSorter((RowSorter)this.a);
/*     */   }
/*     */   
/*     */   private void cz() {
/* 173 */     String str = "Clique aqui para enviar um lance manual";
/*     */     
/* 175 */     d d = new d();
/* 176 */     r r = new r(4);
/* 177 */     r.a((b)d);
/* 178 */     v v = new v();
/* 179 */     v.a((b)new b());
/*     */     
/* 181 */     getColumnModel().getColumn(0)
/* 182 */       .setCellRenderer((TableCellRenderer)new v());
/* 183 */     getColumnModel().getColumn(1)
/* 184 */       .setCellRenderer((TableCellRenderer)new v());
/* 185 */     getColumnModel().getColumn(2)
/* 186 */       .setCellRenderer((TableCellRenderer)new v(str));
/* 187 */     getColumnModel().getColumn(3)
/* 188 */       .setCellRenderer((TableCellRenderer)v);
/* 189 */     getColumnModel().getColumn(4)
/* 190 */       .setCellRenderer((TableCellRenderer)new v());
/* 191 */     getColumnModel().getColumn(5)
/* 192 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 193 */     getColumnModel().getColumn(6)
/* 194 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 195 */     getColumnModel().getColumn(7)
/* 196 */       .setCellRenderer((TableCellRenderer)new w());
/* 197 */     getColumnModel().getColumn(9)
/* 198 */       .setCellRenderer((TableCellRenderer)r);
/* 199 */     getColumnModel().getColumn(11)
/* 200 */       .setCellRenderer((TableCellRenderer)r);
/* 201 */     getColumnModel().getColumn(11)
/* 202 */       .setCellEditor((TableCellEditor)new q());
/* 203 */     getColumnModel().getColumn(10)
/* 204 */       .setCellRenderer((TableCellRenderer)r);
/* 205 */     getColumnModel().getColumn(10)
/* 206 */       .setCellEditor((TableCellEditor)new q());
/* 207 */     getColumnModel().getColumn(8)
/* 208 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 209 */     getColumnModel().getColumn(12)
/* 210 */       .setCellRenderer((TableCellRenderer)new x(4));
/* 211 */     getColumnModel().getColumn(13)
/* 212 */       .setCellRenderer((TableCellRenderer)new x(4));
/* 213 */     getColumnModel().getColumn(15)
/* 214 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 215 */     getColumnModel().getColumn(16)
/* 216 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 217 */     getColumnModel().getColumn(14)
/* 218 */       .setCellRenderer((TableCellRenderer)new r(0));
/* 219 */     getColumnModel().getColumn(17)
/* 220 */       .setCellRenderer((TableCellRenderer)new r(0));
/*     */   }
/*     */   
/*     */   private void cE() {
/* 224 */     ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/img/online-icon.png"));
/* 225 */     ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/img/offline-icon.png"));
/* 226 */     ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("/img/clock.png"));
/*     */     
/* 228 */     Border border = UIManager.getBorder("TableHeader.cellBorder");
/*     */     
/* 230 */     JLabel jLabel1 = new JLabel(imageIcon1, 0);
/* 231 */     jLabel1.setBorder(border);
/* 232 */     jLabel1.setToolTipText("Usuários online na sala de disputa");
/*     */     
/* 234 */     JLabel jLabel2 = new JLabel(imageIcon2, 0);
/* 235 */     jLabel2.setBorder(border);
/* 236 */     jLabel2.setToolTipText("Usuários offline na sala de disputa");
/*     */     
/* 238 */     JLabel jLabel3 = new JLabel(imageIcon3, 0);
/* 239 */     jLabel3.setBorder(border);
/* 240 */     jLabel3.setToolTipText("Tempo para próximo lance");
/*     */     
/* 242 */     TableCellRenderer tableCellRenderer = (paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2) -> (JComponent)paramObject;
/*     */     
/* 244 */     TableColumn tableColumn1 = getColumnModel().getColumn(15);
/* 245 */     tableColumn1.setHeaderRenderer(tableCellRenderer);
/* 246 */     tableColumn1.setHeaderValue(jLabel1);
/*     */     
/* 248 */     TableColumn tableColumn2 = getColumnModel().getColumn(16);
/* 249 */     tableColumn2.setHeaderRenderer(tableCellRenderer);
/* 250 */     tableColumn2.setHeaderValue(jLabel2);
/*     */     
/* 252 */     TableColumn tableColumn3 = getColumnModel().getColumn(14);
/* 253 */     tableColumn3.setHeaderRenderer(tableCellRenderer);
/* 254 */     tableColumn3.setHeaderValue(jLabel3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JTableHeader createDefaultTableHeader() {
/* 259 */     return new JTableHeader(this, this.columnModel)
/*     */       {
/*     */         public String getToolTipText(MouseEvent param1MouseEvent) {
/* 262 */           Point point = param1MouseEvent.getPoint();
/* 263 */           int i = this.columnModel.getColumnIndexAtX(point.x);
/* 264 */           int j = this.columnModel.getColumn(i).getModelIndex();
/*     */           
/* 266 */           if (j != 4) {
/* 267 */             return null;
/*     */           }
/* 269 */           return "Disputa contra ME/EPP";
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics paramGraphics) {
/* 276 */     super.paint(paramGraphics);
/* 277 */     cF();
/*     */   }
/*     */   
/*     */   private void cF() {
/* 281 */     TableColumn tableColumn1 = getColumnModel().getColumn(7);
/* 282 */     TableColumn tableColumn2 = getColumnModel().getColumn(8);
/* 283 */     TableColumn tableColumn3 = getColumnModel().getColumn(9);
/* 284 */     TableColumn tableColumn4 = getColumnModel().getColumn(10);
/* 285 */     TableColumn tableColumn5 = getColumnModel().getColumn(11);
/* 286 */     TableColumn tableColumn6 = getColumnModel().getColumn(12);
/* 287 */     TableColumn tableColumn7 = getColumnModel().getColumn(13);
/*     */     
/* 289 */     int i = (int)(getWidth() - getMinimumSize().getWidth());
/* 290 */     int j = i;
/*     */     
/* 292 */     int k = (int)(i * 0.08D);
/* 293 */     j -= k;
/* 294 */     k += this.bS;
/* 295 */     y.a(tableColumn3, k);
/*     */     
/* 297 */     int m = (int)(i * 0.08D);
/* 298 */     j -= m;
/* 299 */     m += this.bT;
/* 300 */     y.a(tableColumn4, m);
/*     */     
/* 302 */     if (this.bU > 0) {
/* 303 */       int i3 = (int)(i * 0.08D);
/* 304 */       j -= i3;
/* 305 */       i3 += this.bU;
/* 306 */       y.a(tableColumn5, i3);
/*     */     } 
/*     */     
/* 309 */     int n = (int)(i * 0.08D);
/* 310 */     j -= n;
/* 311 */     n += this.bV;
/* 312 */     y.a(tableColumn6, n);
/*     */     
/* 314 */     int i1 = (int)(i * 0.08D);
/* 315 */     j -= i1;
/* 316 */     i1 += this.bW;
/* 317 */     y.a(tableColumn7, i1);
/*     */     
/* 319 */     int i2 = (int)(i * 0.15D);
/* 320 */     j -= i2;
/* 321 */     i2 += this.bR;
/* 322 */     y.a(tableColumn2, i2);
/*     */     
/* 324 */     j += this.bQ;
/* 325 */     y.a(tableColumn1, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowSorter(RowSorter<? extends TableModel> paramRowSorter) {}
/*     */ 
/*     */   
/*     */   public TableRowSorter<i> a() {
/* 334 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(RowFilter<i, Integer> paramRowFilter) {
/* 338 */     this.a.setRowFilter(paramRowFilter);
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
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {
/*     */     try {
/* 352 */       if (paramInt2 == 10) {
/* 353 */         int i = convertRowIndexToModel(paramInt1);
/* 354 */         e e = ((i)getModel()).b(i);
/* 355 */         double d1 = e.l();
/* 356 */         double d2 = ((Double)paramObject).doubleValue();
/*     */         
/* 358 */         if (d2 < d1) {
/* 359 */           int j = (int)((1.0D - d2 / d1) * 100.0D);
/*     */           
/* 361 */           if (j >= 75) {
/* 362 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*     */ 
/*     */             
/* 365 */             String str = "A redução no valor limite do item " + e.bo() + " foi de " + j + "%.\nVocê confirma a alteração para o valor de R$" + decimalFormat.format(d2) + "?";
/* 366 */             a.info(str);
/* 367 */             int k = JOptionPane.showConfirmDialog(null, str, "Alerta", 0, 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 375 */             if (k == 1) {
/* 376 */               a.info("Rejeitou alteração de valor limite");
/*     */               
/*     */               return;
/*     */             } 
/* 380 */             a.info("Confirmou alteração de valor limite");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 386 */       if (paramInt2 == 10 || paramInt2 == 11) {
/* 387 */         a(paramInt1, paramObject);
/*     */       }
/*     */     }
/* 390 */     catch (Exception exception) {}
/*     */ 
/*     */     
/* 393 */     super.setValueAt(paramObject, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, Object paramObject) {
/* 397 */     int i = convertRowIndexToModel(paramInt);
/* 398 */     e e = ((i)getModel()).b(i);
/* 399 */     double d = ((Double)paramObject).doubleValue();
/*     */     
/* 401 */     if (!a(a(d), e.b().E())) {
/* 402 */       JOptionPane.showMessageDialog(null, "Foram arredondados os limites dos itens que possuiam mais casas decimais do que o configurado. \nNúmero configurado no arredondamento de lance: " + e
/*     */ 
/*     */           
/* 405 */           .b().E(), "Alerta", 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(double paramDouble) {
/* 412 */     String str = BigDecimal.valueOf(paramDouble).stripTrailingZeros().toPlainString();
/*     */     
/* 414 */     int i = str.indexOf(".");
/* 415 */     if (i == -1) {
/* 416 */       return -1;
/*     */     }
/* 418 */     return str.length() - i - 1;
/*     */   }
/*     */   
/*     */   private boolean a(int paramInt1, int paramInt2) {
/* 422 */     return ((paramInt1 == -1 && paramInt2 >= 4) || paramInt1 <= 4 - paramInt2);
/*     */   }
/*     */   
/*     */   public void aj(int paramInt) {
/* 426 */     this.bQ = paramInt;
/*     */   }
/*     */   
/*     */   public void ak(int paramInt) {
/* 430 */     this.bR = paramInt;
/*     */   }
/*     */   
/*     */   public void al(int paramInt) {
/* 434 */     this.bS = paramInt;
/*     */   }
/*     */   
/*     */   public void am(int paramInt) {
/* 438 */     this.bT = paramInt;
/*     */   }
/*     */   
/*     */   public void an(int paramInt) {
/* 442 */     this.bU = paramInt;
/*     */   }
/*     */   
/*     */   public void ao(int paramInt) {
/* 446 */     this.bV = paramInt;
/*     */   }
/*     */   
/*     */   public void ap(int paramInt) {
/* 450 */     this.bW = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */