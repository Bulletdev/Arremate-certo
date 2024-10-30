/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.b.L;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */ {
/*  24 */   protected static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private final i a;
/*     */   
/*     */   private final Calendar a;
/*     */   
/*     */   private final Calendar b;
/*     */   private AtomicBoolean a;
/*     */   private String E;
/*     */   private int j;
/*     */   
/*     */   public a(i parami) {
/*  36 */     this.E = "";
/*  37 */     this.a = (AtomicBoolean)parami;
/*     */     
/*  39 */     this.a = (AtomicBoolean)y.i();
/*     */     
/*  41 */     this.b = Calendar.getInstance();
/*  42 */     this.b.setTime(this.a.getTime());
/*  43 */     this.b.add(2, -6);
/*     */   }
/*     */   
/*     */   public i a() {
/*  47 */     return (i)this.a;
/*     */   }
/*     */   
/*     */   protected final Calendar e() {
/*  51 */     return (Calendar)this.a;
/*     */   }
/*     */   
/*     */   protected final boolean a(Calendar paramCalendar) {
/*  55 */     return (paramCalendar.compareTo(this.b) < 0);
/*     */   }
/*     */   
/*     */   protected final Calendar f() {
/*  59 */     return this.b;
/*     */   }
/*     */   
/*     */   public AtomicBoolean a() {
/*  63 */     return this.a;
/*     */   }
/*     */   
/*     */   protected void f(String paramString) {
/*  67 */     this.E = paramString;
/*     */   }
/*     */   
/*     */   public String j() {
/*  71 */     return this.E;
/*     */   }
/*     */   
/*     */   protected void a(int paramInt) {
/*  75 */     this.j = paramInt;
/*     */   }
/*     */   
/*     */   public int c() {
/*  79 */     return this.j;
/*     */   }
/*     */   
/*     */   protected boolean a(int paramInt) {
/*  83 */     return a(Integer.toString(paramInt));
/*     */   }
/*     */   
/*     */   protected boolean a(String paramString) {
/*  87 */     return a(this.a.av(), this.a.a().b(), paramString);
/*     */   }
/*     */   
/*     */   public static boolean a(String paramString1, n paramn, String paramString2) {
/*  91 */     StringBuilder stringBuilder = new StringBuilder();
/*  92 */     stringBuilder.append("SELECT COUNT(*) AS total FROM tblicitacao WHERE empcnpj = ");
/*  93 */     stringBuilder.append(paramString1);
/*     */     
/*  95 */     boolean bool = (paramn.a() == o.e || paramn.a() == o.p) ? true : false;
/*  96 */     if (bool) {
/*  97 */       stringBuilder.append(" AND licnumero = '").append(paramString2).append("'");
/*     */     } else {
/*  99 */       stringBuilder.append(" AND liccodigo = ").append(paramString2);
/*     */     } 
/*     */     
/* 102 */     stringBuilder.append(" AND porcodigo = ").append(paramn.v());
/*     */     
/* 104 */     try(Statement null = br.com.arremate.e.a.a().createStatement(); ResultSet null = statement.executeQuery(stringBuilder.toString())) {
/* 105 */       if (resultSet.next()) {
/* 106 */         return (resultSet.getInt("total") != 0);
/*     */       }
/* 108 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public List<j> a(List<j> paramList, AtomicBoolean paramAtomicBoolean) {
/* 115 */     a(0);
/*     */     
/* 117 */     if (!a().isRunning()) {
/* 118 */       f(String.join(" ", new CharSequence[] { "Erro ao realizar comunicação com o portal", a().a().b().K() }));
/* 119 */       a(2);
/* 120 */       return null;
/*     */     } 
/*     */     
/* 123 */     this.a = paramAtomicBoolean;
/*     */     
/*     */     try {
/* 126 */       return a(paramList);
/* 127 */     } catch (Exception exception) {
/* 128 */       f("Erro ao carregar lista de pregões");
/* 129 */       a(0);
/* 130 */       a.error("Error loading biddings from the Portal", exception);
/* 131 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(AtomicBoolean paramAtomicBoolean, String paramString) {
/*     */     List<j> list;
/*     */     try {
/* 139 */       list = a(paramString);
/* 140 */       if (list.isEmpty()) {
/* 141 */         if (j() == null || j().isEmpty()) {
/* 142 */           f("Erro ao carregar o pregão! Verifique se o código/número foi digitado de acordo com o presente no Portal e tente novamente!");
/*     */         }
/*     */         
/* 145 */         a(0);
/* 146 */         return null;
/*     */       } 
/* 148 */     } catch (Exception exception) {
/* 149 */       f("Erro ao carregar o pregão! Verifique se o código/número foi digitado corretamente e tente novamente.");
/* 150 */       a(0);
/* 151 */       a.error("Error loading biddings from the Portal", exception);
/* 152 */       return null;
/*     */     } 
/*     */     
/* 155 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(String paramString1, String paramString2) {
/*     */     List<j> list;
/*     */     try {
/* 162 */       list = b(paramString1, paramString2);
/*     */       
/* 164 */       if (list.isEmpty()) {
/* 165 */         if (L.isNullOrEmpty(j())) {
/* 166 */           f("Erro ao carregar o pregão. Verifique se o código/número e o nome do órgão foram digitados de acordo com o presente no Portal e tente novamente!");
/*     */         }
/*     */         
/* 169 */         a(0);
/* 170 */         return null;
/*     */       } 
/* 172 */     } catch (Exception exception) {
/* 173 */       f("Erro ao carregar o pregão. Verifique se o código/número e o nome do órgão foram digitados de acordo com o presente no Portal e tente novamente!");
/* 174 */       a(0);
/* 175 */       a.error("Error loading biddings from the Portal", exception);
/* 176 */       return null;
/*     */     } 
/*     */     
/* 179 */     return list;
/*     */   }
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 183 */     return null;
/*     */   }
/*     */   
/*     */   protected List<j> b(String paramString1, String paramString2) throws Exception {
/* 187 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract List<j> a(List<j> paramList) throws Exception;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */