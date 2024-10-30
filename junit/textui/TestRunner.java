/*     */ package junit.textui;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import junit.b.i;
/*     */ import junit.b.j;
/*     */ import junit.b.m;
/*     */ import junit.b.n;
/*     */ import junit.runner.Version;
/*     */ import junit.runner.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TestRunner
/*     */   extends a
/*     */ {
/*     */   private a a;
/*     */   public static final int hW = 0;
/*     */   public static final int hX = 1;
/*     */   public static final int hY = 2;
/*     */   
/*     */   public TestRunner() {
/*  41 */     this(System.out);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestRunner(PrintStream paramPrintStream) {
/*  48 */     this(new a(paramPrintStream));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestRunner(a parama) {
/*  55 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void f(Class<? extends j> paramClass) {
/*  62 */     a((i)new n(paramClass));
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
/*     */   public static m a(i parami) {
/*  76 */     TestRunner testRunner = new TestRunner();
/*  77 */     return testRunner.b(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void d(i parami) {
/*  85 */     TestRunner testRunner = new TestRunner();
/*  86 */     testRunner.a(parami, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int paramInt, i parami, Throwable paramThrowable) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void be(String paramString) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void bf(String paramString) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected m c() {
/* 105 */     return new m();
/*     */   }
/*     */   
/*     */   public m b(i parami) {
/* 109 */     return a(parami, false);
/*     */   }
/*     */   
/*     */   public m a(i parami, boolean paramBoolean) {
/* 113 */     m m = c();
/* 114 */     m.a(this.a);
/* 115 */     long l1 = System.currentTimeMillis();
/* 116 */     parami.a(m);
/* 117 */     long l2 = System.currentTimeMillis();
/* 118 */     long l3 = l2 - l1;
/* 119 */     this.a.a(m, l3);
/*     */     
/* 121 */     at(paramBoolean);
/* 122 */     return m;
/*     */   }
/*     */   
/*     */   protected void at(boolean paramBoolean) {
/* 126 */     if (!paramBoolean)
/* 127 */       return;  this.a.hk();
/*     */     try {
/* 129 */       System.in.read();
/* 130 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 135 */     TestRunner testRunner = new TestRunner();
/*     */     try {
/* 137 */       m m = testRunner.a(paramArrayOfString);
/* 138 */       if (!m.er()) {
/* 139 */         System.exit(1);
/*     */       }
/* 141 */       System.exit(0);
/* 142 */     } catch (Exception exception) {
/* 143 */       System.err.println(exception.getMessage());
/* 144 */       System.exit(2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m a(String[] paramArrayOfString) throws Exception {
/* 153 */     String str1 = "";
/* 154 */     String str2 = "";
/* 155 */     boolean bool = false;
/*     */     
/* 157 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 158 */       if (paramArrayOfString[b].equals("-wait")) {
/* 159 */         bool = true;
/* 160 */       } else if (paramArrayOfString[b].equals("-c")) {
/* 161 */         str1 = aF(paramArrayOfString[++b]);
/* 162 */       } else if (paramArrayOfString[b].equals("-m")) {
/* 163 */         String str = paramArrayOfString[++b];
/* 164 */         int i = str.lastIndexOf('.');
/* 165 */         str1 = str.substring(0, i);
/* 166 */         str2 = str.substring(i + 1);
/* 167 */       } else if (paramArrayOfString[b].equals("-v")) {
/* 168 */         System.err.println("JUnit " + Version.id() + " by Kent Beck and Erich Gamma");
/*     */       } else {
/* 170 */         str1 = paramArrayOfString[b];
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     if (str1.equals("")) {
/* 175 */       throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
/*     */     }
/*     */     
/*     */     try {
/* 179 */       if (!str2.equals("")) {
/* 180 */         return a(str1, str2, bool);
/*     */       }
/* 182 */       i i = b(str1);
/* 183 */       return a(i, bool);
/* 184 */     } catch (Exception exception) {
/* 185 */       throw new Exception("Could not create and run test suite: " + exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected m a(String paramString1, String paramString2, boolean paramBoolean) throws Exception {
/* 190 */     Class clazz = a(paramString1).asSubclass(j.class);
/* 191 */     i i = n.a(clazz, paramString2);
/* 192 */     return a(i, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bg(String paramString) {
/* 197 */     System.err.println(paramString);
/* 198 */     System.exit(1);
/*     */   }
/*     */   
/*     */   public void a(a parama) {
/* 202 */     this.a = parama;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\textui\TestRunner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */