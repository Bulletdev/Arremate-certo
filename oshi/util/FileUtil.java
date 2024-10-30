/*     */ package oshi.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ @ThreadSafe
/*     */ public final class FileUtil
/*     */ {
/*  54 */   private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String READING_LOG = "Reading file {}";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String READ_LOG = "Read {}";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> readFile(String paramString) {
/*  72 */     return readFile(paramString, true);
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
/*     */   public static List<String> readFile(String paramString, boolean paramBoolean) {
/*  87 */     if ((new File(paramString)).canRead()) {
/*  88 */       if (LOG.isDebugEnabled()) {
/*  89 */         LOG.debug("Reading file {}", paramString);
/*     */       }
/*     */       try {
/*  92 */         return Files.readAllLines(Paths.get(paramString, new String[0]), StandardCharsets.UTF_8);
/*  93 */       } catch (IOException iOException) {
/*  94 */         if (paramBoolean) {
/*  95 */           LOG.error("Error reading file {}. {}", paramString, iOException.getMessage());
/*     */         } else {
/*  97 */           LOG.debug("Error reading file {}. {}", paramString, iOException.getMessage());
/*     */         } 
/*     */       } 
/* 100 */     } else if (paramBoolean) {
/* 101 */       LOG.warn("File not found or not readable: {}", paramString);
/*     */     } 
/* 103 */     return new ArrayList<>();
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
/*     */   public static byte[] readAllBytes(String paramString) {
/* 115 */     return readAllBytes(paramString, true);
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
/*     */   public static byte[] readAllBytes(String paramString, boolean paramBoolean) {
/* 129 */     if ((new File(paramString)).canRead()) {
/* 130 */       if (LOG.isDebugEnabled()) {
/* 131 */         LOG.debug("Reading file {}", paramString);
/*     */       }
/*     */       try {
/* 134 */         return Files.readAllBytes(Paths.get(paramString, new String[0]));
/* 135 */       } catch (IOException iOException) {
/* 136 */         if (paramBoolean) {
/* 137 */           LOG.error("Error reading file {}. {}", paramString, iOException.getMessage());
/*     */         } else {
/* 139 */           LOG.debug("Error reading file {}. {}", paramString, iOException.getMessage());
/*     */         } 
/*     */       } 
/* 142 */     } else if (paramBoolean) {
/* 143 */       LOG.warn("File not found or not readable: {}", paramString);
/*     */     } 
/* 145 */     return new byte[0];
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
/*     */   public static long getLongFromFile(String paramString) {
/* 157 */     if (LOG.isDebugEnabled()) {
/* 158 */       LOG.debug("Reading file {}", paramString);
/*     */     }
/* 160 */     List<String> list = readFile(paramString, false);
/* 161 */     if (!list.isEmpty()) {
/* 162 */       if (LOG.isTraceEnabled()) {
/* 163 */         LOG.trace("Read {}", list.get(0));
/*     */       }
/* 165 */       return ParseUtil.parseLongOrDefault(list.get(0), 0L);
/*     */     } 
/* 167 */     return 0L;
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
/*     */   public static long getUnsignedLongFromFile(String paramString) {
/* 179 */     if (LOG.isDebugEnabled()) {
/* 180 */       LOG.debug("Reading file {}", paramString);
/*     */     }
/* 182 */     List<String> list = readFile(paramString, false);
/* 183 */     if (!list.isEmpty()) {
/* 184 */       if (LOG.isTraceEnabled()) {
/* 185 */         LOG.trace("Read {}", list.get(0));
/*     */       }
/* 187 */       return ParseUtil.parseUnsignedLongOrDefault(list.get(0), 0L);
/*     */     } 
/* 189 */     return 0L;
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
/*     */   public static int getIntFromFile(String paramString) {
/* 201 */     if (LOG.isDebugEnabled()) {
/* 202 */       LOG.debug("Reading file {}", paramString);
/*     */     }
/*     */     try {
/* 205 */       List<String> list = readFile(paramString, false);
/* 206 */       if (!list.isEmpty()) {
/* 207 */         if (LOG.isTraceEnabled()) {
/* 208 */           LOG.trace("Read {}", list.get(0));
/*     */         }
/* 210 */         return Integer.parseInt(list.get(0));
/*     */       } 
/* 212 */     } catch (NumberFormatException numberFormatException) {
/* 213 */       LOG.warn("Unable to read value from {}. {}", paramString, numberFormatException.getMessage());
/*     */     } 
/* 215 */     return 0;
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
/*     */   public static String getStringFromFile(String paramString) {
/* 227 */     if (LOG.isDebugEnabled()) {
/* 228 */       LOG.debug("Reading file {}", paramString);
/*     */     }
/* 230 */     List<String> list = readFile(paramString, false);
/* 231 */     if (!list.isEmpty()) {
/* 232 */       if (LOG.isTraceEnabled()) {
/* 233 */         LOG.trace("Read {}", list.get(0));
/*     */       }
/* 235 */       return list.get(0);
/*     */     } 
/* 237 */     return "";
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
/*     */   public static Map<String, String> getKeyValueMapFromFile(String paramString1, String paramString2) {
/* 256 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 257 */     if (LOG.isDebugEnabled()) {
/* 258 */       LOG.debug("Reading file {}", paramString1);
/*     */     }
/* 260 */     List<String> list = readFile(paramString1, false);
/* 261 */     for (String str : list) {
/* 262 */       String[] arrayOfString = str.split(paramString2);
/* 263 */       if (arrayOfString.length == 2) {
/* 264 */         hashMap.put(arrayOfString[0], arrayOfString[1].trim());
/*     */       }
/*     */     } 
/* 267 */     return (Map)hashMap;
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
/*     */   public static Properties readPropertiesFromFilename(String paramString) {
/* 279 */     Properties properties = new Properties();
/*     */ 
/*     */     
/* 282 */     for (ClassLoader classLoader : Stream.<ClassLoader>of(
/*     */         
/* 284 */         new ClassLoader[] { Thread.currentThread().getContextClassLoader(), ClassLoader.getSystemClassLoader(), FileUtil.class.getClassLoader() }).collect(Collectors.toCollection(java.util.LinkedHashSet::new))) {
/* 285 */       if (readPropertiesFromClassLoader(paramString, properties, classLoader)) {
/* 286 */         return properties;
/*     */       }
/*     */     } 
/* 289 */     LOG.warn("Failed to load default configuration");
/* 290 */     return properties;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean readPropertiesFromClassLoader(String paramString, Properties paramProperties, ClassLoader paramClassLoader) {
/* 295 */     if (paramClassLoader == null) {
/* 296 */       return false;
/*     */     }
/*     */     
/*     */     try {
/* 300 */       ArrayList<URL> arrayList = Collections.list(paramClassLoader.getResources(paramString));
/* 301 */       if (arrayList.isEmpty()) {
/* 302 */         LOG.debug("No {} file found from ClassLoader {}", paramString, paramClassLoader);
/* 303 */         return false;
/*     */       } 
/* 305 */       if (arrayList.size() > 1) {
/* 306 */         LOG.warn("Configuration conflict: there is more than one {} file on the classpath", paramString);
/* 307 */         return true;
/*     */       } 
/*     */       
/* 310 */       InputStream inputStream = ((URL)arrayList.get(0)).openStream(); 
/* 311 */       try { if (inputStream != null) {
/* 312 */           paramProperties.load(inputStream);
/*     */         }
/* 314 */         if (inputStream != null) inputStream.close();  } catch (Throwable throwable) { if (inputStream != null)
/* 315 */           try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return true;
/* 316 */     } catch (IOException iOException) {
/* 317 */       return false;
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
/*     */   public static String readSymlinkTarget(File paramFile) {
/*     */     try {
/* 330 */       return Files.readSymbolicLink(Paths.get(paramFile.getAbsolutePath(), new String[0])).toString();
/* 331 */     } catch (IOException iOException) {
/* 332 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */