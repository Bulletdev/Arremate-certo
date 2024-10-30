/*     */ package org.c.a.b.c;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.a.a;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.h.i;
/*     */ import org.c.a.b.p.c;
/*     */ import org.c.a.b.r.m;
/*     */ import org.c.a.b.r.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*  38 */   private static final a a = c.b(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final a b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final d[] a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.c.a.b.e.a.b paramb, c paramc, d[] paramArrayOfd, a parama, boolean paramBoolean) {
/*  77 */     this.b = paramb.a();
/*  78 */     this.a = (a)paramc;
/*  79 */     this.a = (a)paramArrayOfd;
/*  80 */     this.a = parama;
/*  81 */     this.cq = paramBoolean;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void clean() throws a {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield cq : Z
/*     */     //   4: ifeq -> 17
/*     */     //   7: new org/c/a/a/a
/*     */     //   10: dup
/*     */     //   11: ldc 'Unable to execute clean as it has been disabled with the "flyway.cleanDisabled" property.'
/*     */     //   13: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   16: athrow
/*     */     //   17: aload_0
/*     */     //   18: getfield a : Lorg/c/a/b/a/a;
/*     */     //   21: getstatic org/c/a/a/b/e.a : Lorg/c/a/a/b/e;
/*     */     //   24: invokeinterface a : (Lorg/c/a/a/b/e;)V
/*     */     //   29: aload_0
/*     */     //   30: getfield b : Lorg/c/a/b/e/a/a;
/*     */     //   33: aload_0
/*     */     //   34: getfield a : [Lorg/c/a/b/e/a/d;
/*     */     //   37: iconst_0
/*     */     //   38: aaload
/*     */     //   39: invokevirtual c : (Lorg/c/a/b/e/a/d;)V
/*     */     //   42: iconst_0
/*     */     //   43: istore_1
/*     */     //   44: aload_0
/*     */     //   45: getfield a : Lorg/c/a/b/p/c;
/*     */     //   48: invokevirtual fS : ()Z
/*     */     //   51: istore_1
/*     */     //   52: goto -> 67
/*     */     //   55: astore_2
/*     */     //   56: getstatic org/c/a/b/c/b.a : Lorg/c/a/a/f/a;
/*     */     //   59: ldc 'Error while checking whether the schemas should be dropped'
/*     */     //   61: aload_2
/*     */     //   62: invokeinterface a : (Ljava/lang/String;Ljava/lang/Exception;)V
/*     */     //   67: aload_0
/*     */     //   68: getfield a : [Lorg/c/a/b/e/a/d;
/*     */     //   71: astore_2
/*     */     //   72: aload_2
/*     */     //   73: arraylength
/*     */     //   74: istore_3
/*     */     //   75: iconst_0
/*     */     //   76: istore #4
/*     */     //   78: iload #4
/*     */     //   80: iload_3
/*     */     //   81: if_icmpge -> 154
/*     */     //   84: aload_2
/*     */     //   85: iload #4
/*     */     //   87: aaload
/*     */     //   88: astore #5
/*     */     //   90: aload #5
/*     */     //   92: invokevirtual exists : ()Z
/*     */     //   95: ifne -> 129
/*     */     //   98: getstatic org/c/a/b/c/b.a : Lorg/c/a/a/f/a;
/*     */     //   101: new java/lang/StringBuilder
/*     */     //   104: dup
/*     */     //   105: invokespecial <init> : ()V
/*     */     //   108: ldc 'Unable to clean unknown schema: '
/*     */     //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   113: aload #5
/*     */     //   115: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   118: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   121: invokeinterface warn : (Ljava/lang/String;)V
/*     */     //   126: goto -> 148
/*     */     //   129: iload_1
/*     */     //   130: ifeq -> 142
/*     */     //   133: aload_0
/*     */     //   134: aload #5
/*     */     //   136: invokespecial a : (Lorg/c/a/b/e/a/d;)V
/*     */     //   139: goto -> 148
/*     */     //   142: aload_0
/*     */     //   143: aload #5
/*     */     //   145: invokespecial b : (Lorg/c/a/b/e/a/d;)V
/*     */     //   148: iinc #4, 1
/*     */     //   151: goto -> 78
/*     */     //   154: goto -> 172
/*     */     //   157: astore_1
/*     */     //   158: aload_0
/*     */     //   159: getfield a : Lorg/c/a/b/a/a;
/*     */     //   162: getstatic org/c/a/a/b/e.c : Lorg/c/a/a/b/e;
/*     */     //   165: invokeinterface a : (Lorg/c/a/a/b/e;)V
/*     */     //   170: aload_1
/*     */     //   171: athrow
/*     */     //   172: aload_0
/*     */     //   173: getfield a : Lorg/c/a/b/a/a;
/*     */     //   176: getstatic org/c/a/a/b/e.b : Lorg/c/a/a/b/e;
/*     */     //   179: invokeinterface a : (Lorg/c/a/a/b/e;)V
/*     */     //   184: aload_0
/*     */     //   185: getfield a : Lorg/c/a/b/p/c;
/*     */     //   188: invokevirtual clearCache : ()V
/*     */     //   191: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #90	-> 0
/*     */     //   #91	-> 7
/*     */     //   #93	-> 17
/*     */     //   #96	-> 29
/*     */     //   #97	-> 42
/*     */     //   #99	-> 44
/*     */     //   #102	-> 52
/*     */     //   #100	-> 55
/*     */     //   #101	-> 56
/*     */     //   #104	-> 67
/*     */     //   #105	-> 90
/*     */     //   #106	-> 98
/*     */     //   #107	-> 126
/*     */     //   #110	-> 129
/*     */     //   #111	-> 133
/*     */     //   #113	-> 142
/*     */     //   #104	-> 148
/*     */     //   #119	-> 154
/*     */     //   #116	-> 157
/*     */     //   #117	-> 158
/*     */     //   #118	-> 170
/*     */     //   #121	-> 172
/*     */     //   #122	-> 184
/*     */     //   #123	-> 191
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   29	154	157	org/c/a/a/a
/*     */     //   44	52	55	java/lang/Exception
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
/*     */ 
/*     */   
/*     */   private void a(d paramd) {
/* 132 */     a.debug("Dropping schema " + paramd + " ...");
/* 133 */     m m = new m();
/* 134 */     m.start();
/*     */     try {
/* 136 */       (new i(this.b.c())).execute(new Callable(this, paramd)
/*     */           {
/*     */             public Void b() {
/* 139 */               this.b.drop();
/* 140 */               return null;
/*     */             }
/*     */           });
/* 143 */     } catch (org.c.a.b.f.b b1) {
/* 144 */       a.debug(b1.getMessage());
/* 145 */       a.warn("Unable to drop schema " + paramd + ". Attempting clean instead...");
/* 146 */       (new i(this.b.c())).execute(new Callable(this, paramd)
/*     */           {
/*     */             public Void b() {
/* 149 */               this.b.clean();
/* 150 */               return null;
/*     */             }
/*     */           });
/*     */     } 
/* 154 */     m.stop();
/* 155 */     a.info(String.format("Successfully dropped schema %s (execution time %s)", new Object[] { paramd, 
/* 156 */             o.format(m.al()) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(d paramd) {
/* 166 */     a.debug("Cleaning schema " + paramd + " ...");
/* 167 */     m m = new m();
/* 168 */     m.start();
/* 169 */     (new i(this.b.c())).execute(new Callable(this, paramd)
/*     */         {
/*     */           public Void b() {
/* 172 */             this.b.clean();
/* 173 */             return null;
/*     */           }
/*     */         });
/* 176 */     m.stop();
/* 177 */     a.info(String.format("Successfully cleaned schema %s (execution time %s)", new Object[] { paramd, 
/* 178 */             o.format(m.al()) }));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */