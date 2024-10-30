/*     */ package br.com.arremate.n;
/*     */ import br.com.arremate.a.a.b;
/*     */ import br.com.arremate.a.a.c;
/*     */ import br.com.arremate.a.g;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.ComponentListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ public class m extends JFrame {
/*  38 */   private static final Logger LOG = LoggerFactory.getLogger(m.class); private Thread b; private JCheckBox p; private JButton s; private JLabel y; private JLabel n; private JLabel Y; private JLabel N;
/*     */   private JLabel bf;
/*     */   private JPanel a;
/*     */   private JTextField h;
/*     */   private JPasswordField c;
/*     */   private JLabel bg;
/*     */   
/*     */   public m() {
/*  46 */     k();
/*  47 */     this.b = null;
/*  48 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aM(String paramString) {
/*  57 */     this.s.setVisible(false);
/*  58 */     this.s.setEnabled(false);
/*  59 */     this.h.setEnabled(false);
/*  60 */     this.c.setEnabled(false);
/*  61 */     this.p.setEnabled(false);
/*     */     
/*  63 */     this.N.setText(paramString);
/*  64 */     this.N.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cX() {
/*  71 */     this.s.setVisible(true);
/*  72 */     this.s.setEnabled(true);
/*  73 */     this.h.setEnabled(true);
/*  74 */     this.c.setEnabled(true);
/*  75 */     this.p.setEnabled(true);
/*     */     
/*  77 */     this.N.setText("");
/*  78 */     this.N.setIcon((Icon)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dg() {
/*  85 */     pack();
/*  86 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  96 */     this.a = new JPanel();
/*  97 */     this.Y = new JLabel();
/*  98 */     this.p = new JCheckBox();
/*  99 */     this.bf = new JLabel();
/* 100 */     this.N = new JLabel();
/* 101 */     this.c = new JPasswordField();
/* 102 */     this.s = new JButton();
/* 103 */     this.n = new JLabel();
/* 104 */     this.y = new JLabel();
/* 105 */     this.h = new JTextField();
/* 106 */     this.bg = new JLabel();
/*     */     
/* 108 */     setDefaultCloseOperation(3);
/* 109 */     setTitle("Effecti - Disputar");
/* 110 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/* 111 */     setResizable(false);
/*     */     
/* 113 */     this.a.setBackground(new Color(255, 255, 255));
/*     */     
/* 115 */     this.Y.setHorizontalAlignment(2);
/* 116 */     this.Y.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
/* 117 */     this.Y.setHorizontalTextPosition(0);
/*     */     
/* 119 */     this.p.setBackground(new Color(255, 255, 255));
/* 120 */     this.p.setText("Lembrar-me");
/* 121 */     this.p.setToolTipText("Lembrar os dados para o próximo acesso");
/* 122 */     this.p.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/* 124 */             m.a(this.a, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/* 128 */     this.bf.setFont(new Font("Tahoma", 1, 11));
/* 129 */     this.bf.setForeground(y.c());
/* 130 */     this.bf.setText(y.cx());
/*     */     
/* 132 */     this.N.setForeground(new Color(32, 97, 169));
/*     */     
/* 134 */     this.c.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/* 136 */             m.b(this.a, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/* 140 */     this.s.setFont(new Font("Tahoma", 1, 11));
/* 141 */     this.s.setText("Login");
/* 142 */     this.s.setContentAreaFilled(false);
/* 143 */     this.s.setName("btnLogin");
/* 144 */     this.s.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/* 146 */             m.a(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/* 150 */     this.n.setText("Senha:");
/*     */     
/* 152 */     this.y.setText("Usuário:");
/*     */     
/* 154 */     this.h.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/* 156 */             m.c(this.a, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/* 160 */     this.bg.setForeground(y.e());
/* 161 */     this.bg.setHorizontalAlignment(0);
/* 162 */     this.bg.setVerticalAlignment(3);
/* 163 */     this.bg.setHorizontalTextPosition(0);
/* 164 */     this.bg.setPreferredSize(new Dimension(457, 14));
/*     */     
/* 166 */     GroupLayout groupLayout1 = new GroupLayout(this.a);
/* 167 */     this.a.setLayout(groupLayout1);
/* 168 */     groupLayout1.setHorizontalGroup(groupLayout1
/* 169 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 170 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
/* 171 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 172 */             .addGroup(GroupLayout.Alignment.LEADING, groupLayout1.createSequentialGroup()
/* 173 */               .addGap(122, 122, 122)
/* 174 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 175 */                 .addComponent(this.y)
/* 176 */                 .addComponent(this.n))
/* 177 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 178 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */                 .addGroup(groupLayout1.createSequentialGroup()
/* 180 */                   .addComponent(this.s)
/* 181 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 182 */                   .addComponent(this.N, -1, -1, 32767))
/* 183 */                 .addGroup(groupLayout1.createSequentialGroup()
/* 184 */                   .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */                     .addComponent(this.p)
/* 186 */                     .addComponent(this.h, -2, 190, -2)
/* 187 */                     .addComponent(this.c, -2, 190, -2))
/* 188 */                   .addGap(0, 0, 32767))))
/* 189 */             .addGroup(GroupLayout.Alignment.LEADING, groupLayout1.createSequentialGroup()
/* 190 */               .addGap(138, 138, 138)
/* 191 */               .addComponent(this.Y)
/* 192 */               .addGap(0, 0, 32767))
/* 193 */             .addGroup(groupLayout1.createSequentialGroup()
/* 194 */               .addContainerGap(-1, 32767)
/* 195 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 196 */                 .addComponent(this.bg, -2, 457, -2)
/* 197 */                 .addComponent(this.bf))))
/* 198 */           .addContainerGap()));
/*     */     
/* 200 */     groupLayout1.setVerticalGroup(groupLayout1
/* 201 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 202 */         .addGroup(groupLayout1.createSequentialGroup()
/* 203 */           .addContainerGap()
/* 204 */           .addComponent(this.Y)
/* 205 */           .addGap(30, 30, 30)
/* 206 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 207 */             .addComponent(this.h, -2, -1, -2)
/* 208 */             .addComponent(this.y))
/* 209 */           .addGap(1, 1, 1)
/* 210 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 211 */             .addComponent(this.n)
/* 212 */             .addComponent(this.c, -2, -1, -2))
/* 213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 214 */           .addComponent(this.p)
/* 215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 216 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 217 */             .addComponent(this.s)
/* 218 */             .addComponent(this.N))
/* 219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 220 */           .addComponent(this.bg, -1, 0, 32767)
/* 221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 222 */           .addComponent(this.bf)
/* 223 */           .addContainerGap()));
/*     */ 
/*     */     
/* 226 */     GroupLayout groupLayout2 = new GroupLayout(getContentPane());
/* 227 */     getContentPane().setLayout(groupLayout2);
/* 228 */     groupLayout2.setHorizontalGroup(groupLayout2
/* 229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 230 */         .addComponent(this.a, -1, -1, -2));
/*     */     
/* 232 */     groupLayout2.setVerticalGroup(groupLayout2
/* 233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 234 */         .addComponent(this.a, -1, -1, 32767));
/*     */ 
/*     */     
/* 237 */     pack();
/*     */   }
/*     */   
/*     */   private void z(ActionEvent paramActionEvent) {
/* 241 */     dC();
/*     */   }
/*     */   
/*     */   public void dC() {
/* 245 */     if (this.b == null || this.b.getState() == Thread.State.TERMINATED) {
/* 246 */       this.b = new Thread(new a(this));
/* 247 */       this.b.start();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f(KeyEvent paramKeyEvent) {
/* 252 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 253 */       z((ActionEvent)null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void g(KeyEvent paramKeyEvent) {
/* 258 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 259 */       z((ActionEvent)null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void h(KeyEvent paramKeyEvent) {
/* 264 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 265 */       z((ActionEvent)null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected JTextField c() {
/* 270 */     return this.h;
/*     */   }
/*     */   
/*     */   protected JPasswordField a() {
/* 274 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setUser(String paramString) {
/* 278 */     c().setText(paramString);
/*     */   }
/*     */   
/*     */   public void setPassword(String paramString) {
/* 282 */     a().setText(paramString);
/*     */   }
/*     */   
/*     */   public void Z(boolean paramBoolean) {
/* 286 */     this.p.setSelected(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class a
/*     */     implements Runnable
/*     */   {
/*     */     private b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(m this$0) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 312 */       this.a.aM("Processando...");
/*     */       
/*     */       try {
/* 315 */         String str1 = m.a(this.a).getText();
/* 316 */         String str2 = String.valueOf(m.a(this.a).getPassword());
/*     */         
/* 318 */         dE();
/*     */         
/* 320 */         if (f(str1, str2)) {
/* 321 */           j.a().O(m.a(this.a).isSelected());
/* 322 */           dD();
/* 323 */           f(str1, str2);
/* 324 */           this.a.dispose();
/* 325 */           n.a().start();
/* 326 */           b((b)this.a);
/*     */         } 
/* 328 */       } catch (Exception exception) {
/* 329 */         m.a().error("Erro na inicialização", exception);
/*     */       } 
/*     */       
/* 332 */       this.a.cX();
/*     */     }
/*     */     
/*     */     private void dD() {
/* 336 */       try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement("insert into tbsessionid(sessionid, sessioniddate) values (?,?)")) {
/* 337 */         preparedStatement.setString(1, j.cj());
/* 338 */         preparedStatement.setTimestamp(2, new Timestamp((new Date()).getTime()));
/* 339 */         preparedStatement.execute();
/* 340 */       } catch (SQLException sQLException) {
/* 341 */         m.a().error("Erro ao gravar UIID", sQLException);
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean f(String param1String1, String param1String2) throws Exception {
/* 346 */       br.com.arremate.k.c.a a1 = new br.com.arremate.k.c.a();
/*     */       
/* 348 */       if (param1String1.isEmpty() || param1String2.isEmpty()) {
/* 349 */         m.a().info("Não preencheu campos de login e senha");
/* 350 */         JOptionPane.showMessageDialog(null, "Para acessar o sistema é necessário informar seu login e senha", "Erro", 0);
/* 351 */         return false;
/*     */       } 
/*     */       
/* 354 */       String str = a1.aZ();
/* 355 */       this.a = (m)a(g.a().a(param1String1, param1String2, "2.97.0", str));
/*     */       
/* 357 */       if (!a1.a((b)this.a)) {
/* 358 */         return false;
/*     */       }
/*     */       
/* 361 */       c.a().setUser(param1String1);
/*     */       
/* 363 */       if (a1.a((b)this.a, str)) {
/* 364 */         m.a().info("Download da nova versão do atualizador iniciado");
/* 365 */         m.a(this.a).setText("Baixando atualizador...");
/* 366 */         e.a().bB();
/* 367 */         m.a(this.a).setText("Processando...");
/* 368 */         m.a().info("Download da nova versão do atualizador finalizado");
/*     */       } 
/*     */       
/* 371 */       if (!this.a.d()) {
/* 372 */         m.a().info("Finaliza tela de login");
/* 373 */         this.a.dispose();
/* 374 */         m.a().info("Inicializa o atualizador");
/* 375 */         a1.c(param1String1, param1String2);
/* 376 */         return false;
/*     */       } 
/*     */       
/* 379 */       if (!a1.b((b)this.a) || !a1.c((b)this.a)) {
/* 380 */         return false;
/*     */       }
/*     */       
/* 383 */       a1.a((b)this.a);
/* 384 */       c.a().c(this.a.getKey());
/* 385 */       c.a().d(this.a.d());
/* 386 */       c.a().e(this.a.e());
/* 387 */       c.a().a(this.a.f());
/* 388 */       return true;
/*     */     }
/*     */     
/*     */     private b a(i param1i) {
/* 392 */       if (param1i != null) {
/* 393 */         b b1; int j = param1i.getInt("status");
/*     */ 
/*     */         
/* 396 */         if (j > 0) {
/* 397 */           b1 = new b(param1i);
/*     */         } else {
/* 399 */           b1 = new b(j, param1i.getString("message"));
/*     */         } 
/*     */         
/* 402 */         c.a().b(param1i.n("token", null));
/*     */         
/* 404 */         return b1;
/*     */       } 
/*     */       
/* 407 */       return null;
/*     */     }
/*     */     
/*     */     private void f(String param1String1, String param1String2) {
/*     */       try {
/* 412 */         String str = "SELECT * FROM tbconfiguracaoarremate;";
/* 413 */         try(Statement null = br.com.arremate.e.a.a().createStatement(); ResultSet null = statement.executeQuery(str)) {
/* 414 */           if (resultSet.next()) {
/* 415 */             str = "UPDATE tbconfiguracaoarremate SET carlembrardadosacesso = ?, carusuarioacesso = ?, carsenhaacesso = ?";
/*     */           } else {
/* 417 */             str = "INSERT INTO tbconfiguracaoarremate(carlembrardadosacesso, carusuarioacesso, carsenhaacesso) VALUES(?,?,?);";
/*     */           } 
/*     */         } 
/*     */         
/* 421 */         param1String1 = y.R(param1String1);
/* 422 */         param1String2 = y.R(param1String2);
/*     */         
/* 424 */         try (Statement null = br.com.arremate.e.a.a().prepareStatement(str)) {
/* 425 */           statement.setBoolean(1, m.a(this.a).isSelected());
/* 426 */           statement.setString(2, param1String1);
/* 427 */           statement.setString(3, param1String2);
/* 428 */           statement.execute();
/*     */         } 
/* 430 */       } catch (Exception exception) {
/* 431 */         m.a().warn("Falha ao gravar o lembre-me", exception);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void dE() {
/* 436 */       String str = "";
/* 437 */       i i = g.a().c();
/* 438 */       if (i != null && i.has("message")) {
/* 439 */         str = i.getString("message");
/*     */       }
/*     */       
/* 442 */       if (!str.isEmpty()) {
/* 443 */         str = y.a(m.b(this.a).getWidth(), 
/* 444 */             m.b(this.a).getFontMetrics(m.b(this.a).getFont()), str);
/* 445 */         str = "<html><div style='text-align: center;'>" + str + "</html>";
/* 446 */         m.b(this.a).setText(str);
/* 447 */         m.a(this.a).setSize(m.a(this.a).getWidth(), m.c(this.a).getHeight() + m.b(this.a).getHeight());
/* 448 */         m.a(this.a);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void b(b param1b) {
/* 453 */       String str = "configshowbannerlivetrainingme";
/*     */ 
/*     */ 
/*     */       
/* 457 */       boolean bool = (r(str) && y.i().before(y.c("25/02/2022 13:30")) && param1b.c() != null && param1b.c().equals("Flex")) ? true : false;
/*     */       
/* 459 */       a(bool, "/img/Banner-ME-Live-Training.png", str, "Treinamento ao Vivo", "https://www.youtube.com/watch?v=uvhJvKPtGMo");
/*     */     }
/*     */     
/*     */     private boolean r(String param1String) {
/*     */       try {
/* 464 */         String str = "SELECT * FROM tbconfiguracaoarremate;";
/* 465 */         try(Statement null = br.com.arremate.e.a.a().createStatement(); ResultSet null = statement.executeQuery(str)) {
/* 466 */           if (resultSet.next()) {
/* 467 */             return resultSet.getBoolean(param1String);
/*     */           }
/*     */         } 
/* 470 */       } catch (Exception exception) {
/* 471 */         m.a().warn("Error querying show banner", exception);
/*     */       } 
/* 473 */       return true;
/*     */     }
/*     */     
/*     */     private void aN(String param1String) {
/*     */       try {
/* 478 */         String str = "SELECT * FROM tbconfiguracaoarremate;";
/* 479 */         try(Statement null = br.com.arremate.e.a.a().createStatement(); ResultSet null = statement.executeQuery(str)) {
/* 480 */           if (resultSet.next()) {
/* 481 */             str = "UPDATE tbconfiguracaoarremate SET " + param1String + " = false";
/*     */           }
/*     */         } 
/*     */         
/* 485 */         try (Statement null = br.com.arremate.e.a.a().prepareStatement(str)) {
/* 486 */           statement.execute();
/*     */         } 
/* 488 */       } catch (Exception exception) {
/* 489 */         m.a().warn("Error updating show banner", exception);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void a(boolean param1Boolean, String param1String1, String param1String2, String param1String3, String param1String4) {
/* 494 */       if (param1Boolean)
/* 495 */         (new Thread(() -> {
/*     */               try {
/*     */                 JLabel jLabel = new JLabel();
/*     */                 jLabel.setIcon(new ImageIcon(getClass().getResource(param1String1)));
/*     */                 jLabel.setHorizontalAlignment(0);
/*     */                 jLabel.setVerticalTextPosition(0);
/*     */                 jLabel.setHorizontalTextPosition(0);
/*     */                 if (!param1String2.isEmpty()) {
/*     */                   jLabel.setCursor(Cursor.getPredefinedCursor(12));
/*     */                   jLabel.addMouseListener(new MouseAdapter(this, param1String2)
/*     */                       {
/*     */                         public void mouseClicked(MouseEvent param2MouseEvent)
/*     */                         {
/* 508 */                           y.l(this.fK);
/*     */                         }
/*     */                       });
/*     */                 } 
/*     */                 
/*     */                 Object[] arrayOfObject = { "Fechar" };
/*     */                 JOptionPane jOptionPane = new JOptionPane(jLabel, -1, -1, null, arrayOfObject, arrayOfObject[0]);
/*     */                 JDialog jDialog = jOptionPane.createDialog(param1String3);
/*     */                 jDialog.addComponentListener(new ComponentListener(this, param1String4)
/*     */                     {
/*     */                       public void componentHidden(ComponentEvent param2ComponentEvent)
/*     */                       {
/* 520 */                         m.a.a(this.a, this.fL);
/*     */                       }
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/*     */                       public void componentResized(ComponentEvent param2ComponentEvent) {}
/*     */ 
/*     */ 
/*     */                       
/*     */                       public void componentMoved(ComponentEvent param2ComponentEvent) {}
/*     */ 
/*     */ 
/*     */                       
/*     */                       public void componentShown(ComponentEvent param2ComponentEvent) {}
/*     */                     });
/*     */                 jDialog.setIconImage((new ImageIcon(getClass().getResource("/img/information.png"))).getImage());
/*     */                 jDialog.setLocationRelativeTo((Component)null);
/*     */                 jDialog.setVisible(true);
/* 539 */               } catch (Exception exception) {
/*     */                 m.a().warn("Error opening banner", exception);
/*     */               } 
/* 542 */             })).start(); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */