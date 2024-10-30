/*     */ package br.com.arremate.k.c;
/*     */ 
/*     */ import br.com.arremate.a.a.b;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.m.k;
/*     */ import br.com.arremate.m.l;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.m.z;
/*     */ import br.com.arremate.n.k;
/*     */ import br.com.arremate.n.n;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.file.FileSystems;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   private static final String dt = "0";
/*     */   
/*     */   public boolean a(b paramb) {
/*  37 */     if (paramb == null) {
/*  38 */       k.cM();
/*  39 */       return false;
/*     */     } 
/*     */     
/*  42 */     if (!paramb.g()) {
/*  43 */       boolean bool = paramb.isError() ? false : true;
/*  44 */       String str = paramb.isError() ? "Erro" : "Alerta";
/*     */       
/*  46 */       if (paramb.getMessage().contains("<a href")) {
/*     */         
/*  48 */         JOptionPane.showMessageDialog(null, k.a(paramb.getMessage()), str, bool);
/*     */       } else {
/*  50 */         JOptionPane.showMessageDialog(null, paramb.getMessage(), str, bool);
/*     */       } 
/*     */       
/*  53 */       if (paramb.isError()) {
/*  54 */         a.info("Erro na validação de acesso, retorno: {}", paramb.getMessage());
/*  55 */         return false;
/*     */       } 
/*     */       
/*  58 */       a.info("Alerta na validação de acesso, retorno: {}", paramb.getMessage());
/*     */     } 
/*     */     
/*  61 */     if (!paramb.c()) {
/*  62 */       a.info("Termos de uso ainda não foram aceitos");
/*  63 */       k k = new k();
/*  64 */       k.setVisible(true);
/*     */       
/*  66 */       if (!k.ci()) {
/*  67 */         a.info("Não aceitou termos de uso");
/*  68 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     int i = paramb.a();
/*  73 */     if (i != -1 && i <= 15) {
/*  74 */       JOptionPane.showMessageDialog(null, String.join(" ", new CharSequence[] { "Falta(m)", String.valueOf(i), "dia(s) para expirar sua senha!" }), "Alerta", 2);
/*     */     }
/*     */ 
/*     */     
/*  78 */     a.info("Sucesso na validação dos dados de acesso");
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   public boolean a(b paramb, String paramString) {
/*  83 */     cm();
/*  84 */     boolean bool = true;
/*     */     
/*  86 */     a.debug("Updater version = {}", paramString);
/*     */     
/*  88 */     if (!paramString.isEmpty()) {
/*  89 */       bool = !paramb.e() ? true : false;
/*     */     }
/*     */     
/*  92 */     return bool;
/*     */   }
/*     */   
/*     */   private void cm() {
/*  96 */     Path path1 = FileSystems.getDefault().getPath("ArremateAtualizador_new.jar", new String[0]);
/*  97 */     Path path2 = FileSystems.getDefault().getPath("ArremateAtualizador.jar", new String[0]);
/*     */     
/*  99 */     if (Files.exists(path1.toAbsolutePath(), new java.nio.file.LinkOption[0])) {
/* 100 */       if (Files.exists(path2.toAbsolutePath(), new java.nio.file.LinkOption[0])) {
/*     */         try {
/* 102 */           FileUtils.forceDelete(path2.toFile());
/* 103 */         } catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */       
/* 107 */       path1.toFile().renameTo(new File(path2.getFileName().toString()));
/*     */     } 
/*     */   }
/*     */   
/*     */   public String aZ() {
/* 112 */     String str = "";
/* 113 */     Path path = FileSystems.getDefault().getPath("ArremateAtualizador.jar", new String[0]);
/* 114 */     if (SystemUtils.IS_OS_MAC) {
/* 115 */       path = FileSystems.getDefault().getPath("/tmp/ArremateAtualizador.app", new String[0]);
/* 116 */     } else if (SystemUtils.IS_OS_LINUX) {
/* 117 */       path = FileSystems.getDefault().getPath("/tmp/ArremateAtualizador.jar", new String[0]);
/*     */     } 
/*     */     
/* 120 */     if (Files.exists(path.toAbsolutePath(), new java.nio.file.LinkOption[0])) {
/*     */       try {
/* 122 */         if (SystemUtils.IS_OS_MAC) {
/* 123 */           byte b = 1;
/*     */           
/* 125 */           Runtime.getRuntime().exec("open " + path.toString() + " --args").waitFor();
/* 126 */           while (str.isEmpty() && b++ < 3) {
/*     */             try {
/* 128 */               str = new String(Files.readAllBytes(FileSystems.getDefault().getPath("/tmp/ArremateAtualizador.ver", new String[0])));
/* 129 */               str = str.replaceAll("\n", "");
/* 130 */             } catch (Exception exception) {}
/*     */           } 
/*     */ 
/*     */           
/* 134 */           File file = new File("/tmp/ArremateAtualizador.ver");
/* 135 */           while (file.exists()) {
/* 136 */             file.delete();
/*     */           }
/*     */         } else {
/* 139 */           ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "java", "-jar", "ArremateAtualizador.jar" });
/* 140 */           Process process = processBuilder.start();
/* 141 */           InputStream inputStream = process.getInputStream();
/* 142 */           InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
/*     */           
/* 144 */           try (BufferedReader null = new BufferedReader(inputStreamReader)) {
/*     */             String str1;
/* 146 */             while ((str1 = bufferedReader.readLine()) != null) {
/* 147 */               if (str1.contains(".")) {
/* 148 */                 str = str1;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 154 */           process.waitFor();
/* 155 */           process.destroy();
/*     */         } 
/* 157 */       } catch (Exception exception) {
/* 158 */         a.info("Failed to get updater version", exception);
/*     */       } 
/*     */     }
/*     */     
/* 162 */     return str;
/*     */   }
/*     */   
/*     */   public boolean b(b paramb) {
/* 166 */     l.a().c(paramb.a());
/* 167 */     return m(paramb.h());
/*     */   }
/*     */   
/*     */   private boolean m(i parami) {
/* 171 */     if (parami == null) {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     String str = String.valueOf(l.a().a(o.b).v());
/* 176 */     if (parami.has(str)) {
/*     */       try {
/* 178 */         i i1 = parami.j(str);
/* 179 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 180 */         hashMap.put("MANIPULAR", i1.getString("MANIPULAR"));
/* 181 */         hashMap.put("ACOMPANHAR", i1.getString("ACOMPANHAR"));
/* 182 */       } catch (Exception exception) {
/* 183 */         a.error("Erro ao capturar dados", exception);
/* 184 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 188 */     if (parami.has("0")) {
/*     */       try {
/* 190 */         i i1 = parami.j("0");
/* 191 */         n.fM = i1.has("CHAT_URL") ? i1.getString("CHAT_URL") : "";
/* 192 */         n.fN = i1.has("ABRIR_PORTAL_URL") ? i1.getString("ABRIR_PORTAL_URL") : "";
/* 193 */       } catch (Exception exception) {
/* 194 */         a.error("Failed to get portal data urls", exception);
/* 195 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   public boolean c(b paramb) {
/* 203 */     n.a().d(paramb.c());
/* 204 */     return n.bP();
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/*     */     try {
/* 209 */       f f = paramb.b();
/* 210 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 211 */         i i = f.b(b1);
/* 212 */         String str = i.getString("mensagem");
/* 213 */         str = str.replace("\\n", "<br>");
/* 214 */         str = "<html>" + str + "</html>";
/*     */         
/* 216 */         if (i.has("acoes") && i.c("acoes").length() > 0) {
/* 217 */           f f1 = i.c("acoes");
/* 218 */           Object[] arrayOfObject = new Object[f1.length()]; int j;
/* 219 */           for (j = 0; j < f1.length(); j++) {
/* 220 */             arrayOfObject[j] = f1.b(j).getString("mensagem");
/*     */           }
/*     */           
/* 223 */           j = JOptionPane.showOptionDialog(null, str, "Aviso", 2, 1, null, arrayOfObject, arrayOfObject[0]);
/* 224 */           if (j >= 0 && f1.b(j).has("acao")) {
/* 225 */             String str1 = f1.b(j).getString("acao");
/* 226 */             if (str1.contains("http")) {
/* 227 */               y.l(str1);
/*     */             }
/*     */           } 
/*     */         } else {
/* 231 */           JOptionPane.showConfirmDialog(null, str, "Aviso", 2, 1);
/*     */         } 
/*     */       } 
/* 234 */     } catch (Exception exception) {
/* 235 */       a.warn("Failed to show avisosLoginEmpresaAcessoCentralizado", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void c(String paramString1, String paramString2) {
/*     */     try {
/* 241 */       String str1 = y.a(z.a.a);
/* 242 */       String str2 = "java -jar ArremateAtualizador.jar \"\" ";
/* 243 */       if (SystemUtils.IS_OS_MAC) {
/* 244 */         str2 = "open " + str1 + File.separator + "ArremateAtualizador.app --args \"\" ";
/*     */       }
/*     */       
/* 247 */       StringBuilder stringBuilder = new StringBuilder(str2);
/* 248 */       stringBuilder.append("2.97.0").append(" ");
/*     */       
/* 250 */       if (!paramString1.isEmpty() && !paramString2.isEmpty()) {
/* 251 */         stringBuilder.append(paramString1).append(" ");
/* 252 */         stringBuilder.append(paramString2).append(" ");
/*     */       } 
/*     */       
/* 255 */       (new Thread(() -> {
/*     */             try {
/*     */               Runtime.getRuntime().exec(paramStringBuilder.toString().trim());
/* 258 */             } catch (Exception exception) {
/*     */               a.warn("Failed to execute executarAtualizador() method", exception);
/*     */             } 
/* 261 */           })).start();
/* 262 */     } catch (Exception exception) {
/* 263 */       a.warn("Failed to execute executarAtualizador() method", exception);
/*     */     } 
/*     */     
/* 266 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */