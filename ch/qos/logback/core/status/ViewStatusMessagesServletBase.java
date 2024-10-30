/*     */ package ch.qos.logback.core.status;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.helpers.Transform;
/*     */ import ch.qos.logback.core.util.CachingDateFormatter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
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
/*     */ public abstract class ViewStatusMessagesServletBase
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = -3551928133801157219L;
/*  35 */   private static CachingDateFormatter SDF = new CachingDateFormatter("yyyy-MM-dd HH:mm:ss");
/*     */   
/*  37 */   static String SUBMIT = "submit";
/*  38 */   static String CLEAR = "Clear";
/*     */   
/*     */   int count;
/*     */ 
/*     */   
/*     */   protected abstract StatusManager getStatusManager(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
/*     */   
/*     */   protected abstract String getPageTitle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
/*     */   
/*     */   protected void service(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
/*  48 */     this.count = 0;
/*  49 */     StatusManager statusManager = getStatusManager(paramHttpServletRequest, paramHttpServletResponse);
/*     */     
/*  51 */     paramHttpServletResponse.setContentType("text/html");
/*  52 */     PrintWriter printWriter = paramHttpServletResponse.getWriter();
/*     */     
/*  54 */     printWriter.append("<html>\r\n");
/*  55 */     printWriter.append("<head>\r\n");
/*  56 */     printCSS(paramHttpServletRequest.getContextPath(), printWriter);
/*  57 */     printWriter.append("</head>\r\n");
/*  58 */     printWriter.append("<body>\r\n");
/*  59 */     printWriter.append(getPageTitle(paramHttpServletRequest, paramHttpServletResponse));
/*     */     
/*  61 */     printWriter.append("<form method=\"POST\">\r\n");
/*  62 */     printWriter.append("<input type=\"submit\" name=\"" + SUBMIT + "\" value=\"" + CLEAR + "\">");
/*  63 */     printWriter.append("</form>\r\n");
/*     */     
/*  65 */     if (CLEAR.equalsIgnoreCase(paramHttpServletRequest.getParameter(SUBMIT))) {
/*  66 */       statusManager.clear();
/*  67 */       statusManager.add(new InfoStatus("Cleared all status messages", this));
/*     */     } 
/*     */     
/*  70 */     printWriter.append("<table>");
/*  71 */     StringBuilder stringBuilder = new StringBuilder();
/*  72 */     if (statusManager != null) {
/*  73 */       printList(stringBuilder, statusManager);
/*     */     } else {
/*  75 */       printWriter.append("Could not find status manager");
/*     */     } 
/*  77 */     printWriter.append(stringBuilder);
/*  78 */     printWriter.append("</table>");
/*  79 */     printWriter.append("</body>\r\n");
/*  80 */     printWriter.append("</html>\r\n");
/*  81 */     printWriter.flush();
/*  82 */     printWriter.close();
/*     */   }
/*     */   
/*     */   public void printCSS(String paramString, PrintWriter paramPrintWriter) {
/*  86 */     paramPrintWriter.append("  <STYLE TYPE=\"text/css\">\r\n");
/*  87 */     paramPrintWriter.append("    .warn  { font-weight: bold; color: #FF6600;} \r\n");
/*  88 */     paramPrintWriter.append("    .error { font-weight: bold; color: #CC0000;} \r\n");
/*  89 */     paramPrintWriter.append("    table { margin-left: 2em; margin-right: 2em; border-left: 2px solid #AAA; }\r\n");
/*  90 */     paramPrintWriter.append("    tr.even { background: #FFFFFF; }\r\n");
/*  91 */     paramPrintWriter.append("    tr.odd  { background: #EAEAEA; }\r\n");
/*  92 */     paramPrintWriter.append("    td { padding-right: 1ex; padding-left: 1ex; border-right: 2px solid #AAA; }\r\n");
/*  93 */     paramPrintWriter.append("    td.date { text-align: right; font-family: courier, monospace; font-size: smaller; }");
/*  94 */     paramPrintWriter.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/*  96 */     paramPrintWriter.append("  td.level { text-align: right; }");
/*  97 */     paramPrintWriter.append(CoreConstants.LINE_SEPARATOR);
/*  98 */     paramPrintWriter.append("    tr.header { background: #596ED5; color: #FFF; font-weight: bold; font-size: larger; }");
/*  99 */     paramPrintWriter.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 101 */     paramPrintWriter.append("  td.exception { background: #A2AEE8; white-space: pre; font-family: courier, monospace;}");
/* 102 */     paramPrintWriter.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 104 */     paramPrintWriter.append("  </STYLE>\r\n");
/*     */   }
/*     */ 
/*     */   
/*     */   public void printList(StringBuilder paramStringBuilder, StatusManager paramStatusManager) {
/* 109 */     paramStringBuilder.append("<table>\r\n");
/* 110 */     printHeader(paramStringBuilder);
/* 111 */     List<Status> list = paramStatusManager.getCopyOfStatusList();
/* 112 */     for (Status status : list) {
/* 113 */       this.count++;
/* 114 */       printStatus(paramStringBuilder, status);
/*     */     } 
/* 116 */     paramStringBuilder.append("</table>\r\n");
/*     */   }
/*     */   
/*     */   public void printHeader(StringBuilder paramStringBuilder) {
/* 120 */     paramStringBuilder.append("  <tr class=\"header\">\r\n");
/* 121 */     paramStringBuilder.append("    <th>Date </th>\r\n");
/* 122 */     paramStringBuilder.append("    <th>Level</th>\r\n");
/* 123 */     paramStringBuilder.append("    <th>Origin</th>\r\n");
/* 124 */     paramStringBuilder.append("    <th>Message</th>\r\n");
/* 125 */     paramStringBuilder.append("  </tr>\r\n");
/*     */   }
/*     */ 
/*     */   
/*     */   String statusLevelAsString(Status paramStatus) {
/* 130 */     switch (paramStatus.getEffectiveLevel()) {
/*     */       case 0:
/* 132 */         return "INFO";
/*     */       case 1:
/* 134 */         return "<span class=\"warn\">WARN</span>";
/*     */       case 2:
/* 136 */         return "<span class=\"error\">ERROR</span>";
/*     */     } 
/* 138 */     return null;
/*     */   }
/*     */   
/*     */   String abbreviatedOrigin(Status paramStatus) {
/* 142 */     Object object = paramStatus.getOrigin();
/* 143 */     if (object == null) {
/* 144 */       return null;
/*     */     }
/* 146 */     String str = object.getClass().getName();
/* 147 */     int i = str.lastIndexOf('.');
/* 148 */     if (i != -1) {
/* 149 */       return str.substring(i + 1, str.length());
/*     */     }
/* 151 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private void printStatus(StringBuilder paramStringBuilder, Status paramStatus) {
/*     */     String str1;
/* 157 */     if (this.count % 2 == 0) {
/* 158 */       str1 = "even";
/*     */     } else {
/* 160 */       str1 = "odd";
/*     */     } 
/* 162 */     paramStringBuilder.append("  <tr class=\"").append(str1).append("\">\r\n");
/* 163 */     String str2 = SDF.format(paramStatus.getDate().longValue());
/* 164 */     paramStringBuilder.append("    <td class=\"date\">").append(str2).append("</td>\r\n");
/* 165 */     paramStringBuilder.append("    <td class=\"level\">").append(statusLevelAsString(paramStatus)).append("</td>\r\n");
/* 166 */     paramStringBuilder.append("    <td>").append(abbreviatedOrigin(paramStatus)).append("</td>\r\n");
/* 167 */     paramStringBuilder.append("    <td>").append(paramStatus.getMessage()).append("</td>\r\n");
/* 168 */     paramStringBuilder.append("  </tr>\r\n");
/* 169 */     if (paramStatus.getThrowable() != null) {
/* 170 */       printThrowable(paramStringBuilder, paramStatus.getThrowable());
/*     */     }
/*     */   }
/*     */   
/*     */   private void printThrowable(StringBuilder paramStringBuilder, Throwable paramThrowable) {
/* 175 */     paramStringBuilder.append("  <tr>\r\n");
/* 176 */     paramStringBuilder.append("    <td colspan=\"4\" class=\"exception\"><pre>");
/* 177 */     StringWriter stringWriter = new StringWriter();
/* 178 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/* 179 */     paramThrowable.printStackTrace(printWriter);
/* 180 */     paramStringBuilder.append(Transform.escapeTags(stringWriter.getBuffer()));
/* 181 */     paramStringBuilder.append("    </pre></td>\r\n");
/* 182 */     paramStringBuilder.append("  </tr>\r\n");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\ViewStatusMessagesServletBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */