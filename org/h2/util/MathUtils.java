/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MathUtils
/*     */ {
/*     */   static SecureRandom cachedSecureRandom;
/*     */   static volatile boolean seeded;
/*  30 */   private static final Random RANDOM = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int roundUpInt(int paramInt1, int paramInt2) {
/*  48 */     return paramInt1 + paramInt2 - 1 & -paramInt2;
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
/*     */   public static long roundUpLong(long paramLong1, long paramLong2) {
/*  62 */     return paramLong1 + paramLong2 - 1L & -paramLong2;
/*     */   }
/*     */   
/*     */   private static synchronized SecureRandom getSecureRandom() {
/*  66 */     if (cachedSecureRandom != null) {
/*  67 */       return cachedSecureRandom;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  74 */       cachedSecureRandom = SecureRandom.getInstance("SHA1PRNG");
/*     */ 
/*     */ 
/*     */       
/*  78 */       Runnable runnable = new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/*  82 */               SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
/*  83 */               byte[] arrayOfByte = secureRandom.generateSeed(20);
/*  84 */               synchronized (MathUtils.cachedSecureRandom) {
/*  85 */                 MathUtils.cachedSecureRandom.setSeed(arrayOfByte);
/*  86 */                 MathUtils.seeded = true;
/*     */               } 
/*  88 */             } catch (Exception exception) {
/*     */               
/*  90 */               MathUtils.warn("SecureRandom", exception);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/*     */       try {
/*  96 */         Thread thread = new Thread(runnable, "Generate Seed");
/*     */ 
/*     */         
/*  99 */         thread.setDaemon(true);
/* 100 */         thread.start();
/* 101 */         Thread.yield();
/*     */         
/*     */         try {
/* 104 */           thread.join(400L);
/* 105 */         } catch (InterruptedException interruptedException) {
/* 106 */           warn("InterruptedException", interruptedException);
/*     */         } 
/* 108 */         if (!seeded) {
/* 109 */           byte[] arrayOfByte = generateAlternativeSeed();
/*     */           
/* 111 */           synchronized (cachedSecureRandom) {
/* 112 */             cachedSecureRandom.setSeed(arrayOfByte);
/*     */           } 
/*     */         } 
/* 115 */       } catch (SecurityException securityException) {
/*     */         
/* 117 */         runnable.run();
/* 118 */         generateAlternativeSeed();
/*     */       }
/*     */     
/* 121 */     } catch (Exception exception) {
/*     */       
/* 123 */       warn("SecureRandom", exception);
/* 124 */       cachedSecureRandom = new SecureRandom();
/*     */     } 
/* 126 */     return cachedSecureRandom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] generateAlternativeSeed() {
/*     */     try {
/* 136 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 137 */       DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*     */ 
/*     */       
/* 140 */       dataOutputStream.writeLong(System.currentTimeMillis());
/* 141 */       dataOutputStream.writeLong(System.nanoTime());
/*     */ 
/*     */       
/* 144 */       dataOutputStream.writeInt((new Object()).hashCode());
/* 145 */       Runtime runtime = Runtime.getRuntime();
/* 146 */       dataOutputStream.writeLong(runtime.freeMemory());
/* 147 */       dataOutputStream.writeLong(runtime.maxMemory());
/* 148 */       dataOutputStream.writeLong(runtime.totalMemory());
/*     */ 
/*     */       
/*     */       try {
/* 152 */         String str = System.getProperties().toString();
/*     */ 
/*     */         
/* 155 */         dataOutputStream.writeInt(str.length());
/* 156 */         dataOutputStream.write(str.getBytes("UTF-8"));
/* 157 */       } catch (Exception exception) {
/* 158 */         warn("generateAlternativeSeed", exception);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 164 */         Class<?> clazz = Class.forName("java.net.InetAddress");
/*     */         
/* 166 */         Object object = clazz.getMethod("getLocalHost", new Class[0]).invoke(null, new Object[0]);
/*     */         
/* 168 */         String str = clazz.getMethod("getHostName", new Class[0]).invoke(object, new Object[0]).toString();
/*     */         
/* 170 */         dataOutputStream.writeUTF(str);
/* 171 */         Object[] arrayOfObject = (Object[])clazz.getMethod("getAllByName", new Class[] { String.class }).invoke(null, new Object[] { str });
/*     */         
/* 173 */         Method method = clazz.getMethod("getAddress", new Class[0]);
/*     */         
/* 175 */         for (Object object1 : arrayOfObject) {
/* 176 */           dataOutputStream.write((byte[])method.invoke(object1, new Object[0]));
/*     */         }
/* 178 */       } catch (Throwable throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       for (byte b = 0; b < 16; b++) {
/* 186 */         byte b1 = 0;
/* 187 */         long l = System.currentTimeMillis();
/* 188 */         while (l == System.currentTimeMillis()) {
/* 189 */           b1++;
/*     */         }
/* 191 */         dataOutputStream.writeInt(b1);
/*     */       } 
/*     */       
/* 194 */       dataOutputStream.close();
/* 195 */       return byteArrayOutputStream.toByteArray();
/* 196 */     } catch (IOException iOException) {
/* 197 */       warn("generateAlternativeSeed", iOException);
/* 198 */       return new byte[1];
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
/*     */   static void warn(String paramString, Throwable paramThrowable) {
/* 211 */     System.out.println("Warning: " + paramString);
/* 212 */     if (paramThrowable != null) {
/* 213 */       paramThrowable.printStackTrace();
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
/*     */   public static int nextPowerOf2(int paramInt) {
/* 225 */     long l = 1L;
/* 226 */     while (l < paramInt && l < 1073741823L) {
/* 227 */       l += l;
/*     */     }
/* 229 */     return (int)l;
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
/*     */   public static int convertLongToInt(long paramLong) {
/* 241 */     if (paramLong <= -2147483648L)
/* 242 */       return Integer.MIN_VALUE; 
/* 243 */     if (paramLong >= 2147483647L) {
/* 244 */       return Integer.MAX_VALUE;
/*     */     }
/* 246 */     return (int)paramLong;
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
/*     */   public static int compareInt(int paramInt1, int paramInt2) {
/* 259 */     return (paramInt1 == paramInt2) ? 0 : ((paramInt1 < paramInt2) ? -1 : 1);
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
/*     */   public static int compareLong(long paramLong1, long paramLong2) {
/* 271 */     return (paramLong1 == paramLong2) ? 0 : ((paramLong1 < paramLong2) ? -1 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long secureRandomLong() {
/* 280 */     SecureRandom secureRandom = getSecureRandom();
/* 281 */     synchronized (secureRandom) {
/* 282 */       return secureRandom.nextLong();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void randomBytes(byte[] paramArrayOfbyte) {
/* 292 */     RANDOM.nextBytes(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] secureRandomBytes(int paramInt) {
/* 302 */     if (paramInt <= 0) {
/* 303 */       paramInt = 1;
/*     */     }
/* 305 */     byte[] arrayOfByte = new byte[paramInt];
/* 306 */     SecureRandom secureRandom = getSecureRandom();
/* 307 */     synchronized (secureRandom) {
/* 308 */       secureRandom.nextBytes(arrayOfByte);
/*     */     } 
/* 310 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int randomInt(int paramInt) {
/* 321 */     return RANDOM.nextInt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int secureRandomInt(int paramInt) {
/* 332 */     SecureRandom secureRandom = getSecureRandom();
/* 333 */     synchronized (secureRandom) {
/* 334 */       return secureRandom.nextInt(paramInt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\MathUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */