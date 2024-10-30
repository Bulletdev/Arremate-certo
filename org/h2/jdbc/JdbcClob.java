/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PipedInputStream;
/*     */ import java.io.PipedOutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.sql.Clob;
/*     */ import java.sql.NClob;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.Task;
/*     */ import org.h2.value.Value;
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
/*     */ public class JdbcClob
/*     */   extends TraceObject
/*     */   implements NClob
/*     */ {
/*     */   Value value;
/*     */   private final JdbcConnection conn;
/*     */   
/*     */   public JdbcClob(JdbcConnection paramJdbcConnection, Value paramValue, int paramInt) {
/*  41 */     setTrace(paramJdbcConnection.getSession().getTrace(), 10, paramInt);
/*  42 */     this.conn = paramJdbcConnection;
/*  43 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() throws SQLException {
/*     */     try {
/*  54 */       debugCodeCall("length");
/*  55 */       checkClosed();
/*  56 */       if (this.value.getType() == 16) {
/*  57 */         long l = this.value.getPrecision();
/*  58 */         if (l > 0L) {
/*  59 */           return l;
/*     */         }
/*     */       } 
/*  62 */       return IOUtils.copyAndCloseInput(this.value.getReader(), null, Long.MAX_VALUE);
/*  63 */     } catch (Exception exception) {
/*  64 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(long paramLong) throws SQLException {
/*  73 */     throw unsupported("LOB update");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getAsciiStream() throws SQLException {
/*     */     try {
/*  84 */       debugCodeCall("getAsciiStream");
/*  85 */       checkClosed();
/*  86 */       String str = this.value.getString();
/*  87 */       return IOUtils.getInputStreamFromString(str);
/*  88 */     } catch (Exception exception) {
/*  89 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream setAsciiStream(long paramLong) throws SQLException {
/*  98 */     throw unsupported("LOB update");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getCharacterStream() throws SQLException {
/*     */     try {
/* 109 */       debugCodeCall("getCharacterStream");
/* 110 */       checkClosed();
/* 111 */       return this.value.getReader();
/* 112 */     } catch (Exception exception) {
/* 113 */       throw logAndConvert(exception);
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
/*     */ 
/*     */   
/*     */   public Writer setCharacterStream(long paramLong) throws SQLException {
/*     */     try {
/* 130 */       if (isDebugEnabled()) {
/* 131 */         debugCodeCall("setCharacterStream(" + paramLong + ");");
/*     */       }
/* 133 */       checkClosed();
/* 134 */       if (paramLong != 1L) {
/* 135 */         throw DbException.getInvalidValueException("pos", Long.valueOf(paramLong));
/*     */       }
/* 137 */       if (this.value.getPrecision() != 0L) {
/* 138 */         throw DbException.getInvalidValueException("length", Long.valueOf(this.value.getPrecision()));
/*     */       }
/* 140 */       final JdbcConnection c = this.conn;
/*     */ 
/*     */ 
/*     */       
/* 144 */       final PipedInputStream in = new PipedInputStream();
/* 145 */       final Task task = new Task()
/*     */         {
/*     */           public void call() {
/* 148 */             JdbcClob.this.value = c.createClob(IOUtils.getReader(in), -1L);
/*     */           }
/*     */         };
/* 151 */       PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream)
/*     */         {
/*     */           public void close() throws IOException {
/* 154 */             super.close();
/*     */             try {
/* 156 */               task.get();
/* 157 */             } catch (Exception exception) {
/* 158 */               throw DbException.convertToIOException(exception);
/*     */             } 
/*     */           }
/*     */         };
/* 162 */       task.execute();
/* 163 */       return IOUtils.getBufferedWriter(pipedOutputStream);
/* 164 */     } catch (Exception exception) {
/* 165 */       throw logAndConvert(exception);
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
/*     */   public String getSubString(long paramLong, int paramInt) throws SQLException {
/*     */     try {
/* 179 */       if (isDebugEnabled()) {
/* 180 */         debugCode("getSubString(" + paramLong + ", " + paramInt + ");");
/*     */       }
/* 182 */       checkClosed();
/* 183 */       if (paramLong < 1L) {
/* 184 */         throw DbException.getInvalidValueException("pos", Long.valueOf(paramLong));
/*     */       }
/* 186 */       if (paramInt < 0) {
/* 187 */         throw DbException.getInvalidValueException("length", Integer.valueOf(paramInt));
/*     */       }
/* 189 */       StringWriter stringWriter = new StringWriter(Math.min(4096, paramInt));
/*     */       
/* 191 */       try (Reader null = this.value.getReader()) {
/* 192 */         IOUtils.skipFully(reader, paramLong - 1L);
/* 193 */         IOUtils.copyAndCloseInput(reader, stringWriter, paramInt);
/*     */       } 
/* 195 */       return stringWriter.toString();
/* 196 */     } catch (Exception exception) {
/* 197 */       throw logAndConvert(exception);
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
/*     */   
/*     */   public int setString(long paramLong, String paramString) throws SQLException {
/*     */     try {
/* 213 */       if (isDebugEnabled()) {
/* 214 */         debugCode("setString(" + paramLong + ", " + quote(paramString) + ");");
/*     */       }
/* 216 */       checkClosed();
/* 217 */       if (paramLong != 1L)
/* 218 */         throw DbException.getInvalidValueException("pos", Long.valueOf(paramLong)); 
/* 219 */       if (paramString == null) {
/* 220 */         throw DbException.getInvalidValueException("str", paramString);
/*     */       }
/* 222 */       this.value = this.conn.createClob(new StringReader(paramString), -1L);
/* 223 */       return paramString.length();
/* 224 */     } catch (Exception exception) {
/* 225 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int setString(long paramLong, String paramString, int paramInt1, int paramInt2) throws SQLException {
/* 235 */     throw unsupported("LOB update");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long position(String paramString, long paramLong) throws SQLException {
/* 243 */     throw unsupported("LOB search");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long position(Clob paramClob, long paramLong) throws SQLException {
/* 251 */     throw unsupported("LOB search");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/* 259 */     debugCodeCall("free");
/* 260 */     this.value = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader getCharacterStream(long paramLong1, long paramLong2) throws SQLException {
/* 268 */     throw unsupported("LOB subset");
/*     */   }
/*     */   
/*     */   private void checkClosed() {
/* 272 */     this.conn.checkClosed();
/* 273 */     if (this.value == null) {
/* 274 */       throw DbException.get(90007);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 283 */     return getTraceObjectName() + ": " + ((this.value == null) ? "null" : this.value.getTraceSQL());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcClob.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */