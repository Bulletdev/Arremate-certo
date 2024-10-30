/*     */ package org.c.a.b.e.i;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.r.n;
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
/*     */ public class d
/*     */   extends d<b>
/*     */ {
/*  39 */   private static final org.c.a.a.f.a a = c.b(d.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   d(org.c.a.b.h.d paramd, b paramb, String paramString) {
/*  49 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fL() throws SQLException {
/*  58 */     return ((b)this.a).J().contains(this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fM() throws SQLException {
/*  67 */     return this.name.equals(((b)this.a).eB());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  72 */     return ((b)this.a).a("SELECT * FROM ALL_USERS WHERE USERNAME = ?", new String[] { this.name });
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  77 */     return !a.a((org.c.a.b.h.d)this.a, (b)this.a, this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  82 */     this.a.a("CREATE USER " + ((b)this.a).d(new String[] { this.name }, ) + " IDENTIFIED BY " + ((b)this.a)
/*  83 */         .d(new String[] { "FFllyywwaayy00!!" }, ), new Object[0]);
/*  84 */     this.a.a("GRANT RESOURCE TO " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*  85 */     this.a.a("GRANT UNLIMITED TABLESPACE TO " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  90 */     this.a.a("DROP USER " + ((b)this.a).d(new String[] { this.name }, ) + " CASCADE", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  95 */     if (fL()) {
/*  96 */       throw new org.c.a.a.a("Clean not supported on Oracle for system schema " + ((b)this.a).d(new String[] { this.name }) + "! It must not be changed in any way except by running an Oracle-supplied script!");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (((b)this.a).fH()) {
/* 102 */       ie();
/*     */     }
/*     */ 
/*     */     
/* 106 */     if (((b)this.a).fK()) {
/* 107 */       if();
/*     */     }
/*     */ 
/*     */     
/* 111 */     Set<String> set = a.a((org.c.a.b.h.d)this.a, (b)this.a, this);
/*     */ 
/*     */     
/* 114 */     List<a> list = Arrays.asList(new a[] { a.r, a.b, a.F, a.E, a.B, a.C, a.D, a.G, a.H, a.I, a.J, a.x, a.A, a.y, a.z, a.j, a.c, a.k, a.i, a.e, a.f, (a)a.a, a.d, a.h, a.m, a.g, a.o, a.n, a.p, a.q, a.w, a.s, a.l, a.t, a.u, a.v, a.K, a.L, a.M, a.N, a.O, a.P, a.Q, a.R, a.S, a.T });
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
/* 170 */     for (a a1 : list) {
/* 171 */       if (set.contains(a1.getName())) {
/* 172 */         a.debug("Cleaning objects of type " + a1 + " ...");
/* 173 */         a1.a((org.c.a.b.h.d)this.a, (b)this.a, this);
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     if (fM()) {
/* 178 */       this.a.a("PURGE RECYCLEBIN", new Object[0]);
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
/*     */   
/*     */   private void ie() throws SQLException {
/* 192 */     boolean bool = (((b)this.a).O("SELECT ANY DICTIONARY") || ((b)this.a).P("DBA_FLASHBACK_ARCHIVE_TABLES")) ? true : false;
/*     */     
/* 194 */     if (!bool && !fM()) {
/* 195 */       a.warn("Unable to check and disable Flashback Archive for tables in schema " + ((b)this.a).d(new String[] { this.name }) + " by user \"" + ((b)this.a)
/* 196 */           .eB() + "\": DBA_FLASHBACK_ARCHIVE_TABLES is not accessible");
/*     */       
/*     */       return;
/*     */     } 
/* 200 */     boolean bool1 = ((b)this.a).c().H("18");
/*     */ 
/*     */ 
/*     */     
/* 204 */     String str = "SELECT TABLE_NAME FROM " + (bool ? "DBA_" : "USER_") + "FLASHBACK_ARCHIVE_TABLES WHERE OWNER_NAME = ?" + (bool1 ? " AND STATUS='ENABLED'" : "");
/* 205 */     List list = this.a.a(str, new String[] { this.name });
/* 206 */     for (String str1 : list) {
/* 207 */       this.a.a("ALTER TABLE " + ((b)this.a).d(new String[] { this.name, str1 }, ) + " NO FLASHBACK ARCHIVE", new Object[0]);
/*     */       
/* 209 */       while (((b)this.a).a(str + " AND TABLE_NAME = ?", new String[] { this.name, str1 })) {
/*     */         try {
/* 211 */           a.debug("Actively waiting for Flashback cleanup on table: " + ((b)this.a).d(new String[] { this.name, str1 }));
/* 212 */           Thread.sleep(1000L);
/* 213 */         } catch (InterruptedException interruptedException) {
/* 214 */           throw new org.c.a.a.a("Waiting for Flashback cleanup interrupted", interruptedException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     if (bool1) {
/* 220 */       while (((b)this.a).a("SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = ?\n AND TABLE_NAME LIKE 'SYS_FBA_DDL_COLMAP_%'", new String[] { this.name })) {
/*     */         
/*     */         try {
/* 223 */           a.debug("Actively waiting for Flashback colmap cleanup");
/* 224 */           Thread.sleep(1000L);
/* 225 */         } catch (InterruptedException interruptedException) {
/* 226 */           throw new org.c.a.a.a("Waiting for Flashback colmap cleanup interrupted", interruptedException);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean fN() throws SQLException {
/* 239 */     return ((b)this.a).a("SELECT * FROM ALL_SDO_GEOM_METADATA WHERE OWNER = ?", new String[] { this.name });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void if() throws SQLException {
/* 249 */     if (!fN()) {
/*     */       return;
/*     */     }
/*     */     
/* 253 */     if (!fM()) {
/* 254 */       a.warn("Unable to clean Oracle Locator metadata for schema " + ((b)this.a).d(new String[] { this.name }) + " by user \"" + ((b)this.a)
/* 255 */           .eB() + "\": unsupported operation");
/*     */       
/*     */       return;
/*     */     } 
/* 259 */     this.a.getConnection().commit();
/* 260 */     this.a.a("DELETE FROM USER_SDO_GEOM_METADATA", new Object[0]);
/* 261 */     this.a.getConnection().commit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 266 */     List<String> list = a.a.a((org.c.a.b.h.d)this.a, (b)this.a, this);
/*     */     
/* 268 */     f[] arrayOfF = new f[list.size()];
/* 269 */     for (byte b = 0; b < list.size(); b++) {
/* 270 */       arrayOfF[b] = new h((org.c.a.b.h.d)this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 272 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 277 */     return new h((org.c.a.b.h.d)this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum a
/*     */   {
/* 286 */     a("TABLE", "CASCADE CONSTRAINTS PURGE")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 289 */         boolean bool1 = param2b.a("SELECT * FROM ALL_PART_TABLES WHERE OWNER = ? AND PARTITIONING_TYPE = 'REFERENCE'", new String[] { param2d1
/*     */               
/* 291 */               .getName() });
/* 292 */         boolean bool2 = param2b.fI();
/*     */         
/* 294 */         StringBuilder stringBuilder = new StringBuilder();
/* 295 */         stringBuilder.append("WITH TABLES AS (\n  SELECT TABLE_NAME, OWNER\n  FROM ALL_TABLES\n  WHERE OWNER = ?\n    AND (IOT_TYPE IS NULL OR IOT_TYPE NOT LIKE '%OVERFLOW%')\n    AND NESTED != 'YES'\n    AND SECONDARY != 'Y'\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 303 */         if (bool2) {
/* 304 */           stringBuilder.append("  UNION ALL\n  SELECT TABLE_NAME, OWNER\n  FROM ALL_XML_TABLES\n  WHERE OWNER = ?\n    AND TABLE_NAME NOT LIKE 'BIN$________________________$_'\n");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 312 */         stringBuilder.append(")\nSELECT t.TABLE_NAME\nFROM TABLES t\n");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 317 */         if (bool1) {
/* 318 */           stringBuilder.append("  LEFT JOIN ALL_PART_TABLES pt\n    ON t.OWNER = pt.OWNER\n   AND t.TABLE_NAME = pt.TABLE_NAME\n   AND pt.PARTITIONING_TYPE = 'REFERENCE'\n  LEFT JOIN ALL_CONSTRAINTS fk\n    ON pt.OWNER = fk.OWNER\n   AND pt.TABLE_NAME = fk.TABLE_NAME\n   AND pt.REF_PTN_CONSTRAINT_NAME = fk.CONSTRAINT_NAME\n   AND fk.CONSTRAINT_TYPE = 'R'\n  LEFT JOIN ALL_CONSTRAINTS puk\n    ON fk.R_OWNER = puk.OWNER\n   AND fk.R_CONSTRAINT_NAME = puk.CONSTRAINT_NAME\n   AND puk.CONSTRAINT_TYPE IN ('P', 'U')\n  LEFT JOIN TABLES p\n    ON puk.OWNER = p.OWNER\n   AND puk.TABLE_NAME = p.TABLE_NAME\nSTART WITH p.TABLE_NAME IS NULL\nCONNECT BY PRIOR t.TABLE_NAME = p.TABLE_NAME\nORDER BY LEVEL DESC");
/*     */         }
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
/* 339 */         int i = 1 + (bool2 ? 1 : 0);
/* 340 */         String[] arrayOfString = new String[i];
/* 341 */         Arrays.fill((Object[])arrayOfString, param2d1.getName());
/*     */         
/* 343 */         return param2d.a(stringBuilder.toString(), arrayOfString);
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 348 */     b("QUEUE TABLE")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 351 */         return param2d.a("SELECT QUEUE_TABLE FROM ALL_QUEUE_TABLES WHERE OWNER = ?", new String[] { param2d1
/*     */               
/* 353 */               .getName() });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 359 */         return "BEGIN DBMS_AQADM.DROP_QUEUE_TABLE('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 364 */     c("MATERIALIZED VIEW LOG")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 367 */         return param2d.a("SELECT MASTER FROM ALL_MVIEW_LOGS WHERE LOG_OWNER = ?", new String[] { param2d1
/*     */               
/* 369 */               .getName() });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 375 */         return "DROP " + getName() + " ON " + param2b.d(new String[] { param2d1.getName(), param2String
/*     */             
/*     */             });
/*     */       }
/*     */     },
/* 380 */     d("INDEX")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 383 */         return param2d.a("SELECT INDEX_NAME FROM ALL_INDEXES WHERE OWNER = ? AND INDEX_TYPE NOT LIKE '%DOMAIN%'", new String[] { param2d1
/*     */ 
/*     */ 
/*     */               
/* 387 */               .getName()
/*     */ 
/*     */             
/*     */             });
/*     */       }
/*     */     },
/* 393 */     e("INDEX", "FORCE")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 396 */         return param2d.a("SELECT INDEX_NAME FROM ALL_INDEXES WHERE OWNER = ? AND INDEX_TYPE LIKE '%DOMAIN%'", new String[] { param2d1
/*     */               
/* 398 */               .getName()
/*     */ 
/*     */             
/*     */             });
/*     */       }
/*     */     },
/* 404 */     f("INDEXTYPE", "FORCE"),
/*     */ 
/*     */     
/* 407 */     g("OPERATOR", "FORCE"),
/*     */ 
/*     */     
/* 410 */     h("CLUSTER", "INCLUDING TABLES CASCADE CONSTRAINTS"),
/*     */ 
/*     */     
/* 413 */     i("VIEW", "CASCADE CONSTRAINTS"),
/*     */ 
/*     */     
/* 416 */     j("MATERIALIZED VIEW", "PRESERVE TABLE"),
/*     */ 
/*     */     
/* 419 */     k("DIMENSION")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 422 */         return param2d.a("SELECT DIMENSION_NAME FROM ALL_DIMENSIONS WHERE OWNER = ?", new String[] { param2d1
/*     */               
/* 424 */               .getName()
/*     */ 
/*     */             
/*     */             });
/*     */       }
/*     */     },
/* 430 */     l("SYNONYM", "FORCE"),
/*     */ 
/*     */     
/* 433 */     m("SEQUENCE"),
/*     */ 
/*     */     
/* 436 */     n("PROCEDURE"),
/* 437 */     o("FUNCTION"),
/* 438 */     p("PACKAGE"),
/*     */ 
/*     */     
/* 441 */     q("CONTEXT")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 444 */         return param2d.a("SELECT NAMESPACE FROM " + param2b
/* 445 */             .aR("CONTEXT") + " WHERE SCHEMA = ?", new String[] { param2d1
/* 446 */               .getName() });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 452 */         return "DROP " + getName() + " " + param2b.d(new String[] { param2String
/*     */             
/*     */             });
/*     */       }
/*     */     },
/* 457 */     r("TRIGGER"),
/*     */ 
/*     */     
/* 460 */     s("TYPE", "FORCE"),
/*     */ 
/*     */     
/* 463 */     t("JAVA SOURCE"),
/* 464 */     u("JAVA CLASS"),
/* 465 */     v("JAVA RESOURCE"),
/*     */ 
/*     */     
/* 468 */     w("LIBRARY"),
/*     */ 
/*     */     
/* 471 */     x("XML SCHEMA")
/*     */     {
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 474 */         if (!param2b.fI()) {
/* 475 */           return Collections.emptyList();
/*     */         }
/* 477 */         return param2d.a("SELECT QUAL_SCHEMA_URL FROM " + param2b
/* 478 */             .aR("XML_SCHEMAS") + " WHERE OWNER = ?", new String[] { param2d1
/* 479 */               .getName() });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 485 */         return "BEGIN DBMS_XMLSCHEMA.DELETESCHEMA('" + param2String + "', DELETE_OPTION => DBMS_XMLSCHEMA.DELETE_CASCADE_FORCE); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 490 */     y("REWRITE EQUIVALENCE")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 493 */         return "BEGIN SYS.DBMS_ADVANCED_REWRITE.DROP_REWRITE_EQUIVALENCE('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "'); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 498 */     z("SQL TRANSLATION PROFILE")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 501 */         return "BEGIN DBMS_SQL_TRANSLATOR.DROP_PROFILE('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "'); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 509 */     A("MINING MODEL")
/*     */     {
/*     */ 
/*     */       
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException
/*     */       {
/* 515 */         return super.a(param2d, param2b, param2d1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 527 */         return "BEGIN DBMS_DATA_MINING.DROP_MODEL('" + param2b
/*     */ 
/*     */ 
/*     */           
/* 531 */           .d(new String[] { param2d1.getName(), param2String }) + "'); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 540 */     B("JOB")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 543 */         return "BEGIN DBMS_SCHEDULER.DROP_JOB('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 546 */     C("PROGRAM")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 549 */         return "BEGIN DBMS_SCHEDULER.DROP_PROGRAM('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 552 */     D("SCHEDULE")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 555 */         return "BEGIN DBMS_SCHEDULER.DROP_SCHEDULE('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 558 */     E("CHAIN")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 561 */         return "BEGIN DBMS_SCHEDULER.DROP_CHAIN('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 564 */     F("FILE WATCHER")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 567 */         return "BEGIN DBMS_SCHEDULER.DROP_FILE_WATCHER('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 572 */     G("RULE SET")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 575 */         return "BEGIN DBMS_RULE_ADM.DROP_RULE_SET('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', DELETE_RULES => FALSE); END;";
/*     */       }
/*     */     },
/* 578 */     H("RULE")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 581 */         return "BEGIN DBMS_RULE_ADM.DROP_RULE('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 584 */     I("EVALUATION CONTEXT")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 587 */         return "BEGIN DBMS_RULE_ADM.DROP_EVALUATION_CONTEXT('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/* 590 */     J("FILE GROUP")
/*     */     {
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 593 */         return "BEGIN DBMS_FILE_GROUP.DROP_FILE_GROUP('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "'); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 602 */     K("DATABASE LINK")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 605 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */ 
/*     */       
/*     */       public List<String> a(org.c.a.b.h.d param2d, b param2b, d param2d1) throws SQLException {
/* 610 */         return param2d.a("SELECT DB_LINK FROM " + param2b
/* 611 */             .aR("DB_LINKS") + " WHERE OWNER = ?", new String[] { param2d1
/* 612 */               .getName() });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 618 */         return "DROP " + getName() + " " + param2String;
/*     */       }
/*     */     },
/* 621 */     L("CREDENTIAL")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 624 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 629 */         return "BEGIN DBMS_SCHEDULER.DROP_CREDENTIAL('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 634 */     M("DESTINATION")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 637 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 642 */         return "BEGIN DBMS_SCHEDULER.DROP_DATABASE_DESTINATION('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "'); END;";
/*     */       }
/*     */     },
/* 645 */     N("SCHEDULER GROUP")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 648 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */ 
/*     */       
/*     */       public String a(org.c.a.b.h.d param2d, b param2b, d param2d1, String param2String) {
/* 653 */         return "BEGIN DBMS_SCHEDULER.DROP_GROUP('" + param2b.d(new String[] { param2d1.getName(), param2String }) + "', FORCE => TRUE); END;";
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 658 */     O("CUBE")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 661 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */     },
/* 664 */     P("CUBE DIMENSION")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 667 */         a(this, param2b.d(new String[] { param2d1.getName() }));
/*     */       }
/*     */     },
/* 670 */     Q("CUBE BUILD PROCESS")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 673 */         a(this, param2b.d(new String[] { param2d1.getName() }, ), "cube build processes");
/*     */       }
/*     */     },
/* 676 */     R("MEASURE FOLDER")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 679 */         a(this, param2b.d(new String[] { param2d1.getName()
/*     */               
/*     */               }));
/*     */       }
/*     */     },
/* 684 */     S("ASSEMBLY")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 687 */         a(this, param2b.d(new String[] { param2d1.getName() }, ), "assemblies");
/*     */       }
/*     */     },
/* 690 */     T("JAVA DATA")
/*     */     {
/*     */       public void a(org.c.a.b.h.d param2d, b param2b, d param2d1) {
/* 693 */         a(this, param2b.d(new String[] { param2d1.getName()
/*     */               
/*     */               }));
/*     */       }
/*     */     },
/* 698 */     U("CAPTURE"),
/* 699 */     V("APPLY"),
/* 700 */     W("DIRECTORY"),
/* 701 */     X("RESOURCE PLAN"),
/* 702 */     Y("CONSUMER GROUP"),
/* 703 */     Z("JOB CLASS"),
/* 704 */     aa("WINDOW"),
/* 705 */     ab("EDITION"),
/* 706 */     ac("DESTINATION"),
/* 707 */     ad("UNIFIED AUDIT POLICY");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String name;
/*     */ 
/*     */     
/*     */     private final String lb;
/*     */ 
/*     */ 
/*     */     
/*     */     a(String param1String1, String param1String2) {
/* 720 */       this.name = param1String1;
/* 721 */       this.lb = param1String2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 729 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 734 */       return super.toString().replace('_', ' ');
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<String> a(org.c.a.b.h.d param1d, b param1b, d param1d1) throws SQLException {
/* 743 */       return param1d.a("SELECT OBJECT_NAME FROM ALL_OBJECTS WHERE OWNER = ? AND OBJECT_TYPE = ?", new String[] { param1d1
/*     */             
/* 745 */             .getName(), getName() });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String a(org.c.a.b.h.d param1d, b param1b, d param1d1, String param1String) {
/* 754 */       return "DROP " + getName() + " " + param1b.d(new String[] { param1d1.getName(), param1String
/* 755 */           }) + (n.X(this.lb) ? (" " + this.lb) : "");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(org.c.a.b.h.d param1d, b param1b, d param1d1) throws SQLException {
/* 764 */       for (String str : a(param1d, param1b, param1d1)) {
/* 765 */         param1d.a(a(param1d, param1b, param1d1, str), new Object[0]);
/*     */       }
/*     */     }
/*     */     
/*     */     private void o(String param1String1, String param1String2) {
/* 770 */       d.c().warn("Unable to clean " + param1String2 + " for schema " + param1String1 + ": unsupported operation");
/*     */     }
/*     */     
/*     */     private void bC(String param1String) {
/* 774 */       o(param1String, toString().toLowerCase() + "s");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Set<String> a(org.c.a.b.h.d param1d, b param1b, d param1d1) throws SQLException {
/* 784 */       boolean bool = param1b.fI();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 820 */       String str = "SELECT DISTINCT OBJECT_TYPE FROM " + param1b.aR("OBJECTS") + " WHERE OWNER = ? UNION SELECT '" + c.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM ALL_MVIEW_LOGS WHERE LOG_OWNER = ?) UNION SELECT '" + k.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM ALL_DIMENSIONS WHERE OWNER = ?) UNION SELECT '" + b.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM ALL_QUEUE_TABLES WHERE OWNER = ?) UNION SELECT '" + K.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM " + param1b.aR("DB_LINKS") + " WHERE OWNER = ?) UNION SELECT '" + q.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM " + param1b.aR("CONTEXT") + " WHERE SCHEMA = ?) " + (bool ? ("UNION SELECT '" + x.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM " + param1b.aR("XML_SCHEMAS") + " WHERE OWNER = ?) ") : "") + "UNION SELECT '" + L.getName() + "' FROM DUAL WHERE EXISTS(SELECT * FROM ALL_SCHEDULER_CREDENTIALS WHERE OWNER = ?) ";
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
/* 832 */       int i = 6 + (bool ? 1 : 0) + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 841 */       String[] arrayOfString = new String[i];
/* 842 */       Arrays.fill((Object[])arrayOfString, param1d1.getName());
/*     */       
/* 844 */       return new HashSet<>(param1d.a(str, arrayOfString));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static boolean a(org.c.a.b.h.d param1d, b param1b, d param1d1) throws SQLException {
/* 854 */       HashSet<String> hashSet = new HashSet<>(a(param1d, param1b, param1d1));
/*     */ 
/*     */       
/* 857 */       hashSet.removeAll(Arrays.asList((Object[])new String[] { K
/* 858 */               .getName(), L
/* 859 */               .getName(), M
/* 860 */               .getName(), N
/* 861 */               .getName(), O
/* 862 */               .getName(), P
/* 863 */               .getName(), Q
/* 864 */               .getName(), R
/* 865 */               .getName(), S
/* 866 */               .getName(), T
/* 867 */               .getName() }));
/*     */ 
/*     */       
/* 870 */       return !hashSet.isEmpty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\i\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */