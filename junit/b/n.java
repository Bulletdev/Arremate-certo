/*     */ package junit.b;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import org.junit.c.i;
/*     */ import org.junit.c.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class n
/*     */   implements i
/*     */ {
/*     */   private String jF;
/*     */   
/*     */   public static i a(Class<?> paramClass, String paramString) {
/*     */     Constructor<?> constructor;
/*     */     Object object;
/*     */     try {
/*  52 */       constructor = a(paramClass);
/*  53 */     } catch (NoSuchMethodException null) {
/*  54 */       return a("Class " + paramClass.getName() + " has no public constructor TestCase(String name) or TestCase()");
/*     */     } 
/*     */     
/*     */     try {
/*  58 */       if ((constructor.getParameterTypes()).length == 0) {
/*  59 */         object = constructor.newInstance(new Object[0]);
/*  60 */         if (object instanceof j) {
/*  61 */           ((j)object).setName(paramString);
/*     */         }
/*     */       } else {
/*  64 */         object = constructor.newInstance(new Object[] { paramString });
/*     */       } 
/*  66 */     } catch (InstantiationException instantiationException) {
/*  67 */       return a("Cannot instantiate test case: " + paramString + " (" + l.c(instantiationException) + ")");
/*  68 */     } catch (InvocationTargetException invocationTargetException) {
/*  69 */       return a("Exception in constructor: " + paramString + " (" + l.c(invocationTargetException.getTargetException()) + ")");
/*  70 */     } catch (IllegalAccessException illegalAccessException) {
/*  71 */       return a("Cannot access test case: " + paramString + " (" + l.c(illegalAccessException) + ")");
/*     */     } 
/*  73 */     return (i)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor<?> a(Class<?> paramClass) throws NoSuchMethodException {
/*     */     try {
/*  82 */       return paramClass.getConstructor(new Class[] { String.class });
/*  83 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */ 
/*     */       
/*  86 */       return paramClass.getConstructor(new Class[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static i a(String paramString) {
/*  93 */     return new j("warning", paramString)
/*     */       {
/*     */         protected void hg() {
/*  96 */           fail(this.jG);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 103 */   private Vector<i> a = new Vector<i>(10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(Class<?> paramClass) {
/* 118 */     d(paramClass);
/*     */   }
/*     */   
/*     */   private void d(Class<?> paramClass) {
/* 122 */     this.jF = paramClass.getName();
/*     */     try {
/* 124 */       a(paramClass);
/* 125 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 126 */       c(a("Class " + paramClass.getName() + " has no public constructor TestCase(String name) or TestCase()"));
/*     */       
/*     */       return;
/*     */     } 
/* 130 */     if (!Modifier.isPublic(paramClass.getModifiers())) {
/* 131 */       c(a("Class " + paramClass.getName() + " is not public"));
/*     */       
/*     */       return;
/*     */     } 
/* 135 */     Class<?> clazz = paramClass;
/* 136 */     ArrayList<String> arrayList = new ArrayList();
/* 137 */     while (i.class.isAssignableFrom(clazz)) {
/* 138 */       for (Method method : i.a(clazz)) {
/* 139 */         a(method, arrayList, paramClass);
/*     */       }
/* 141 */       clazz = clazz.getSuperclass();
/*     */     } 
/* 143 */     if (this.a.size() == 0) {
/* 144 */       c(a("No tests found in " + paramClass.getName()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(Class<? extends j> paramClass, String paramString) {
/* 154 */     this(paramClass);
/* 155 */     setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(String paramString) {
/* 162 */     setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(Class<?>... paramVarArgs) {
/* 171 */     for (Class<?> clazz : paramVarArgs) {
/* 172 */       c(a(clazz));
/*     */     }
/*     */   }
/*     */   
/*     */   private i a(Class<?> paramClass) {
/* 177 */     if (j.class.isAssignableFrom(paramClass)) {
/* 178 */       return new n(paramClass.asSubclass(j.class));
/*     */     }
/* 180 */     return a(paramClass.getCanonicalName() + " does not extend TestCase");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n(Class<? extends j>[] paramArrayOfClass, String paramString) {
/* 190 */     this((Class<?>[])paramArrayOfClass);
/* 191 */     setName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(i parami) {
/* 198 */     this.a.add(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(Class<? extends j> paramClass) {
/* 205 */     c(new n(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bc() {
/* 212 */     int j = 0;
/* 213 */     for (i i1 : this.a) {
/* 214 */       j += i1.bc();
/*     */     }
/* 216 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 225 */     return this.jF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(m paramm) {
/* 232 */     for (i i1 : this.a) {
/* 233 */       if (paramm.eq()) {
/*     */         break;
/*     */       }
/* 236 */       a(i1, paramm);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(i parami, m paramm) {
/* 241 */     parami.a(paramm);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 250 */     this.jF = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i a(int paramInt) {
/* 257 */     return this.a.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bg() {
/* 264 */     return this.a.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<i> c() {
/* 271 */     return this.a.elements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 278 */     if (getName() != null) {
/* 279 */       return getName();
/*     */     }
/* 281 */     return super.toString();
/*     */   }
/*     */   
/*     */   private void a(Method paramMethod, List<String> paramList, Class<?> paramClass) {
/* 285 */     String str = paramMethod.getName();
/* 286 */     if (paramList.contains(str)) {
/*     */       return;
/*     */     }
/* 289 */     if (!c(paramMethod)) {
/* 290 */       if (d(paramMethod)) {
/* 291 */         c(a("Test method isn't public: " + paramMethod.getName() + "(" + paramClass.getCanonicalName() + ")"));
/*     */       }
/*     */       return;
/*     */     } 
/* 295 */     paramList.add(str);
/* 296 */     c(a(paramClass, str));
/*     */   }
/*     */   
/*     */   private boolean c(Method paramMethod) {
/* 300 */     return (d(paramMethod) && Modifier.isPublic(paramMethod.getModifiers()));
/*     */   }
/*     */   
/*     */   private boolean d(Method paramMethod) {
/* 304 */     return ((paramMethod.getParameterTypes()).length == 0 && paramMethod.getName().startsWith("test") && paramMethod.getReturnType().equals(void.class));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */