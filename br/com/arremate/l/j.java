/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.m.y;
/*     */ import java.sql.Statement;
/*     */ import java.util.Calendar;
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
/*     */ public abstract class j
/*     */ {
/*  23 */   protected static final Logger a = LoggerFactory.getLogger(j.class);
/*     */   
/*     */   public boolean ac = false;
/*     */   
/*     */   private final d b;
/*     */   
/*     */   private final int ah;
/*     */   
/*     */   private String dJ;
/*     */   
/*     */   private int aS;
/*     */   private String ei;
/*     */   private l m;
/*     */   private boolean ad;
/*     */   private Calendar f;
/*     */   private String ej;
/*     */   private br.com.arremate.f.j h;
/*     */   private boolean C;
/*     */   private boolean D;
/*     */   private String ek;
/*     */   private boolean Y;
/*     */   private b a;
/*     */   private u m;
/*     */   private m h;
/*     */   private int aT;
/*     */   private int aU;
/*     */   private int aV;
/*     */   private String el;
/*     */   private String em;
/*     */   
/*     */   protected j(d paramd, int paramInt) {
/*  54 */     this.b = paramd;
/*  55 */     this.ah = paramInt;
/*  56 */     this.a = b.a(paramInt, paramd.x(), paramd.b());
/*  57 */     this.C = false;
/*  58 */     this.h = m.a;
/*  59 */     this.m = (u)l.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  64 */     return String.join(" - ", new CharSequence[] { bf(), this.b.b().a().N(), 
/*  65 */           y.k("##.###.###/####-##", String.valueOf(this.b.x())) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean ao();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String bg() {
/*  82 */     return "";
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
/*     */   public boolean delete() {
/*     */     try {
/*  95 */       String str = "DELETE FROM tbarrematelog WHERE empcnpj = " + C() + " AND liccodigo = " + v() + " AND porcodigo = " + b().v();
/*     */       
/*  97 */       Statement statement = a.a().createStatement();
/*  98 */       statement.execute(str);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       str = "DELETE FROM tbitemlicitacao WHERE empcnpj = " + C() + " AND liccodigo = " + v() + " AND porcodigo = " + b().v();
/*     */       
/* 105 */       statement = a.a().createStatement();
/* 106 */       statement.execute(str);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 111 */       str = "DELETE FROM tblicitacao WHERE empcnpj = " + C() + " AND liccodigo = " + v() + " AND porcodigo = " + b().v();
/*     */       
/* 113 */       statement.execute(str);
/* 114 */       statement.close();
/*     */       
/* 116 */       return true;
/* 117 */     } catch (Exception exception) {
/* 118 */       a.error("Falha ao remover pregão (Número {}, UASG {}, Código {})", new Object[] { bo(), Integer.valueOf(K()), Integer.valueOf(v()), exception });
/* 119 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bd() {
/* 129 */     try (Statement null = a.a().createStatement()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       String str = "UPDATE tblicitacao SET licoculta = true WHERE empcnpj = " + C() + " AND liccodigo = " + v() + " AND porcodigo = " + b().v();
/*     */       
/* 136 */       return (statement.executeUpdate(str) != 0);
/* 137 */     } catch (Exception exception) {
/* 138 */       a.error("Falha ao ocultar pregão (Número {}, UASG {}, Código {})", new Object[] { bo(), Integer.valueOf(K()), Integer.valueOf(v()), exception });
/* 139 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] a() {
/* 149 */     String str = (K() != 999) ? Integer.toString(K()) : "";
/* 150 */     return new Object[] { 
/* 151 */         Boolean.valueOf(this.ac), 
/* 152 */         a(), 
/* 153 */         bo(), str, 
/*     */         
/* 155 */         bT(), 
/* 156 */         bS(), 
/* 157 */         a(), 
/* 158 */         a(), 
/* 159 */         Boolean.valueOf(bf()), 
/* 160 */         Boolean.valueOf(k()), 
/* 161 */         (bV() != null) ? bV() : "" };
/*     */   }
/*     */ 
/*     */   
/*     */   public String bS() {
/* 166 */     if (h() == null) {
/* 167 */       return "";
/*     */     }
/*     */     
/* 170 */     return y.formatDate(h().getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract b b();
/*     */ 
/*     */ 
/*     */   
/*     */   public d a() {
/* 181 */     return this.b;
/*     */   }
/*     */   
/*     */   public long C() {
/* 185 */     return a().x();
/*     */   }
/*     */   
/*     */   public int v() {
/* 189 */     return this.ah;
/*     */   }
/*     */   
/*     */   public n b() {
/* 193 */     return a().b();
/*     */   }
/*     */   
/*     */   public String bo() {
/* 197 */     return this.dJ;
/*     */   }
/*     */   
/*     */   public void T(String paramString) {
/* 201 */     this.dJ = paramString;
/*     */   }
/*     */   
/*     */   public int K() {
/* 205 */     return this.aS;
/*     */   }
/*     */   
/*     */   public void Q(int paramInt) {
/* 209 */     this.aS = paramInt;
/*     */   }
/*     */   
/*     */   public String bT() {
/* 213 */     return this.ei;
/*     */   }
/*     */   
/*     */   public void aw(String paramString) {
/* 217 */     this.ei = paramString;
/*     */   }
/*     */   
/*     */   public l a() {
/* 221 */     return (l)this.m;
/*     */   }
/*     */   
/*     */   public void a(l paraml) {
/* 225 */     this.m = (u)paraml;
/*     */   }
/*     */   
/*     */   public boolean be() {
/* 229 */     return this.ad;
/*     */   }
/*     */   
/*     */   public void C(boolean paramBoolean) {
/* 233 */     this.ad = paramBoolean;
/*     */   }
/*     */   
/*     */   public Calendar h() {
/* 237 */     return this.f;
/*     */   }
/*     */   
/*     */   public void b(Calendar paramCalendar) {
/* 241 */     this.f = paramCalendar;
/*     */   }
/*     */   
/*     */   public String bU() {
/* 245 */     return this.ej;
/*     */   }
/*     */   
/*     */   public void ax(String paramString) {
/* 249 */     this.ej = paramString;
/*     */   }
/*     */   
/*     */   public boolean k() {
/* 253 */     return this.D;
/*     */   }
/*     */   
/*     */   public void D(boolean paramBoolean) {
/* 257 */     this.D = paramBoolean;
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
/*     */   public boolean bf() {
/* 269 */     return this.C;
/*     */   }
/*     */   
/*     */   public void s(boolean paramBoolean) {
/* 273 */     this.C = paramBoolean;
/*     */   }
/*     */   
/*     */   public String bV() {
/* 277 */     return this.ek;
/*     */   }
/*     */   
/*     */   public void ay(String paramString) {
/* 281 */     this.ek = paramString;
/*     */   }
/*     */   
/*     */   public boolean aZ() {
/* 285 */     return this.Y;
/*     */   }
/*     */   
/*     */   public void z(boolean paramBoolean) {
/* 289 */     this.Y = paramBoolean;
/*     */   }
/*     */   
/*     */   public br.com.arremate.f.j a() {
/* 293 */     return (br.com.arremate.f.j)this.h;
/*     */   }
/*     */   
/*     */   public void a(br.com.arremate.f.j paramj) {
/* 297 */     this.h = (m)paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b b() {
/* 305 */     if (this.a == null) {
/* 306 */       this.a = b.a(this);
/*     */     }
/*     */     
/* 309 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/* 313 */     this.a = paramb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aU() {
/* 322 */     return b().a(b(), a(), a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String bf() {
/* 332 */     return bo();
/*     */   }
/*     */   
/*     */   public final u a() {
/* 336 */     return this.m;
/*     */   }
/*     */   
/*     */   public final void a(u paramu) {
/* 340 */     this.m = paramu;
/*     */   }
/*     */   
/*     */   public m a() {
/* 344 */     return this.h;
/*     */   }
/*     */   
/*     */   public void a(m paramm) {
/* 348 */     this.h = paramm;
/*     */   }
/*     */   
/*     */   public int D() {
/* 352 */     return 2;
/*     */   }
/*     */   
/*     */   public int L() {
/* 356 */     return this.aT;
/*     */   }
/*     */   
/*     */   public void W(int paramInt) {
/* 360 */     this.aT = paramInt;
/*     */   }
/*     */   
/*     */   public int M() {
/* 364 */     return this.aU;
/*     */   }
/*     */   
/*     */   public void az(String paramString) {
/* 368 */     this.el = paramString;
/*     */   }
/*     */   
/*     */   public String bW() {
/* 372 */     return this.el;
/*     */   }
/*     */   
/*     */   public void X(int paramInt) {
/* 376 */     this.aU = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String bX() {
/* 385 */     boolean bool = (this.aS != 999) ? true : false;
/* 386 */     StringBuilder stringBuilder = new StringBuilder();
/* 387 */     if (bool) {
/* 388 */       stringBuilder.append(Integer.toString(this.aS));
/* 389 */       stringBuilder.append(" - ");
/*     */     } 
/* 391 */     stringBuilder.append(this.dJ);
/* 392 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int N() {
/* 396 */     return this.aV;
/*     */   }
/*     */   
/*     */   public void Y(int paramInt) {
/* 400 */     this.aV = paramInt;
/*     */   }
/*     */   
/*     */   public String bY() {
/* 404 */     return this.em;
/*     */   }
/*     */   
/*     */   public void aA(String paramString) {
/* 408 */     this.em = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */