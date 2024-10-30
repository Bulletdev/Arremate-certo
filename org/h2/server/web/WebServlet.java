/*     */ package org.h2.server.web;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Properties;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.util.New;
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
/*     */ public class WebServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient WebServer server;
/*     */   
/*     */   public void init() {
/*  35 */     ServletConfig servletConfig = getServletConfig();
/*  36 */     Enumeration<E> enumeration = servletConfig.getInitParameterNames();
/*  37 */     ArrayList<String> arrayList = New.arrayList();
/*  38 */     while (enumeration.hasMoreElements()) {
/*  39 */       String str1 = enumeration.nextElement().toString();
/*  40 */       String str2 = servletConfig.getInitParameter(str1);
/*  41 */       if (!str1.startsWith("-")) {
/*  42 */         str1 = "-" + str1;
/*     */       }
/*  44 */       arrayList.add(str1);
/*  45 */       if (str2.length() > 0) {
/*  46 */         arrayList.add(str2);
/*     */       }
/*     */     } 
/*  49 */     String[] arrayOfString = new String[arrayList.size()];
/*  50 */     arrayList.toArray(arrayOfString);
/*  51 */     this.server = new WebServer();
/*  52 */     this.server.setAllowChunked(false);
/*  53 */     this.server.init(arrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroy() {
/*  58 */     this.server.stop();
/*     */   }
/*     */   
/*     */   private boolean allow(HttpServletRequest paramHttpServletRequest) {
/*  62 */     if (this.server.getAllowOthers()) {
/*  63 */       return true;
/*     */     }
/*  65 */     String str = paramHttpServletRequest.getRemoteAddr();
/*     */     try {
/*  67 */       InetAddress inetAddress = InetAddress.getByName(str);
/*  68 */       return inetAddress.isLoopbackAddress();
/*  69 */     } catch (UnknownHostException unknownHostException) {
/*  70 */       return false;
/*  71 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/*     */       
/*  73 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getAllowedFile(HttpServletRequest paramHttpServletRequest, String paramString) {
/*  78 */     if (!allow(paramHttpServletRequest)) {
/*  79 */       return "notAllowed.jsp";
/*     */     }
/*  81 */     if (paramString.length() == 0) {
/*  82 */       return "index.do";
/*     */     }
/*  84 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws IOException {
/*  90 */     paramHttpServletRequest.setCharacterEncoding("utf-8");
/*  91 */     String str1 = paramHttpServletRequest.getPathInfo();
/*  92 */     if (str1 == null) {
/*  93 */       paramHttpServletResponse.sendRedirect(paramHttpServletRequest.getRequestURI() + "/"); return;
/*     */     } 
/*  95 */     if (str1.startsWith("/")) {
/*  96 */       str1 = str1.substring(1);
/*     */     }
/*  98 */     str1 = getAllowedFile(paramHttpServletRequest, str1);
/*     */ 
/*     */     
/* 101 */     Properties properties = new Properties();
/* 102 */     Enumeration<E> enumeration = paramHttpServletRequest.getAttributeNames();
/* 103 */     while (enumeration.hasMoreElements()) {
/* 104 */       String str6 = enumeration.nextElement().toString();
/* 105 */       String str7 = paramHttpServletRequest.getAttribute(str6).toString();
/* 106 */       properties.put(str6, str7);
/*     */     } 
/* 108 */     enumeration = paramHttpServletRequest.getParameterNames();
/* 109 */     while (enumeration.hasMoreElements()) {
/* 110 */       String str6 = enumeration.nextElement().toString();
/* 111 */       String str7 = paramHttpServletRequest.getParameter(str6);
/* 112 */       properties.put(str6, str7);
/*     */     } 
/*     */     
/* 115 */     WebSession webSession = null;
/* 116 */     String str2 = properties.getProperty("jsessionid");
/* 117 */     if (str2 != null) {
/* 118 */       webSession = this.server.getSession(str2);
/*     */     }
/* 120 */     WebApp webApp = new WebApp(this.server);
/* 121 */     webApp.setSession(webSession, properties);
/* 122 */     String str3 = paramHttpServletRequest.getHeader("if-modified-since");
/*     */     
/* 124 */     String str4 = paramHttpServletRequest.getRemoteAddr();
/* 125 */     str1 = webApp.processRequest(str1, str4);
/* 126 */     webSession = webApp.getSession();
/*     */     
/* 128 */     String str5 = webApp.getMimeType();
/* 129 */     boolean bool = webApp.getCache();
/*     */     
/* 131 */     if (bool && this.server.getStartDateTime().equals(str3)) {
/* 132 */       paramHttpServletResponse.setStatus(304);
/*     */       return;
/*     */     } 
/* 135 */     byte[] arrayOfByte = this.server.getFile(str1);
/* 136 */     if (arrayOfByte == null) {
/* 137 */       paramHttpServletResponse.sendError(404);
/* 138 */       arrayOfByte = ("File not found: " + str1).getBytes(Constants.UTF8);
/*     */     } else {
/* 140 */       if (webSession != null && str1.endsWith(".jsp")) {
/* 141 */         String str = new String(arrayOfByte, Constants.UTF8);
/* 142 */         str = PageParser.parse(str, webSession.map);
/* 143 */         arrayOfByte = str.getBytes(Constants.UTF8);
/*     */       } 
/* 145 */       paramHttpServletResponse.setContentType(str5);
/* 146 */       if (!bool) {
/* 147 */         paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
/*     */       } else {
/* 149 */         paramHttpServletResponse.setHeader("Cache-Control", "max-age=10");
/* 150 */         paramHttpServletResponse.setHeader("Last-Modified", this.server.getStartDateTime());
/*     */       } 
/*     */     } 
/* 153 */     if (arrayOfByte != null) {
/* 154 */       ServletOutputStream servletOutputStream = paramHttpServletResponse.getOutputStream();
/* 155 */       servletOutputStream.write(arrayOfByte);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws IOException {
/* 162 */     doGet(paramHttpServletRequest, paramHttpServletResponse);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\WebServlet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */