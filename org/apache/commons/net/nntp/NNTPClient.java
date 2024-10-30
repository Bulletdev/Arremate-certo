/*      */ package org.apache.commons.net.nntp;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Vector;
/*      */ import org.apache.commons.net.MalformedServerReplyException;
/*      */ import org.apache.commons.net.io.DotTerminatedMessageReader;
/*      */ import org.apache.commons.net.io.DotTerminatedMessageWriter;
/*      */ import org.apache.commons.net.io.Util;
/*      */ import org.apache.commons.net.util.NetConstants;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NNTPClient
/*      */   extends NNTP
/*      */ {
/*   90 */   private static final NewsgroupInfo[] EMPTY_NEWSGROUP_INFO_ARRAY = new NewsgroupInfo[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void parseArticlePointer(String paramString, ArticleInfo paramArticleInfo) throws MalformedServerReplyException {
/*  103 */     String[] arrayOfString = paramString.split(" ");
/*  104 */     if (arrayOfString.length >= 3) {
/*  105 */       byte b = 1;
/*      */ 
/*      */       
/*      */       try {
/*  109 */         paramArticleInfo.articleNumber = Long.parseLong(arrayOfString[b++]);
/*      */         
/*  111 */         paramArticleInfo.articleId = arrayOfString[b++];
/*      */         
/*      */         return;
/*  114 */       } catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  119 */     throw new MalformedServerReplyException("Could not parse article pointer.\nServer reply: " + paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void parseGroupReply(String paramString, NewsgroupInfo paramNewsgroupInfo) throws MalformedServerReplyException {
/*  134 */     String[] arrayOfString = paramString.split(" ");
/*  135 */     if (arrayOfString.length >= 5) {
/*  136 */       byte b = 1;
/*      */ 
/*      */       
/*      */       try {
/*  140 */         paramNewsgroupInfo.setArticleCount(Long.parseLong(arrayOfString[b++]));
/*      */         
/*  142 */         paramNewsgroupInfo.setFirstArticle(Long.parseLong(arrayOfString[b++]));
/*      */         
/*  144 */         paramNewsgroupInfo.setLastArticle(Long.parseLong(arrayOfString[b++]));
/*      */         
/*  146 */         paramNewsgroupInfo.setNewsgroup(arrayOfString[b++]);
/*      */         
/*  148 */         paramNewsgroupInfo.setPostingPermission(0);
/*      */         return;
/*  150 */       } catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  156 */     throw new MalformedServerReplyException("Could not parse newsgroup info.\nServer reply: " + paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static NewsgroupInfo parseNewsgroupListEntry(String paramString) {
/*  164 */     String[] arrayOfString = paramString.split(" ");
/*  165 */     if (arrayOfString.length < 4) {
/*  166 */       return null;
/*      */     }
/*  168 */     NewsgroupInfo newsgroupInfo = new NewsgroupInfo();
/*      */     
/*  170 */     byte b = 0;
/*      */     
/*  172 */     newsgroupInfo.setNewsgroup(arrayOfString[b++]);
/*      */ 
/*      */     
/*      */     try {
/*  176 */       long l1 = Long.parseLong(arrayOfString[b++]);
/*  177 */       long l2 = Long.parseLong(arrayOfString[b++]);
/*  178 */       newsgroupInfo.setFirstArticle(l2);
/*  179 */       newsgroupInfo.setLastArticle(l1);
/*  180 */       if (l2 == 0L && l1 == 0L) {
/*  181 */         newsgroupInfo.setArticleCount(0L);
/*      */       } else {
/*  183 */         newsgroupInfo.setArticleCount(l1 - l2 + 1L);
/*      */       } 
/*  185 */     } catch (NumberFormatException numberFormatException) {
/*  186 */       return null;
/*      */     } 
/*      */     
/*  189 */     switch (arrayOfString[b++].charAt(0))
/*      */     
/*      */     { case 'Y':
/*      */       case 'y':
/*  193 */         newsgroupInfo.setPostingPermission(2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  212 */         return newsgroupInfo;case 'N': case 'n': newsgroupInfo.setPostingPermission(3); return newsgroupInfo;case 'M': case 'm': newsgroupInfo.setPostingPermission(1); return newsgroupInfo; }  newsgroupInfo.setPostingPermission(0); return newsgroupInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Article parseArticleEntry(String paramString) {
/*  228 */     Article article = new Article();
/*  229 */     article.setSubject(paramString);
/*  230 */     String[] arrayOfString = paramString.split("\t");
/*  231 */     if (arrayOfString.length > 6) {
/*  232 */       byte b = 0;
/*      */       try {
/*  234 */         article.setArticleNumber(Long.parseLong(arrayOfString[b++]));
/*  235 */         article.setSubject(arrayOfString[b++]);
/*  236 */         article.setFrom(arrayOfString[b++]);
/*  237 */         article.setDate(arrayOfString[b++]);
/*  238 */         article.setArticleId(arrayOfString[b++]);
/*  239 */         article.addReference(arrayOfString[b++]);
/*  240 */       } catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */ 
/*      */     
/*  244 */     return article;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private NewsgroupInfo[] readNewsgroupListing() throws IOException {
/*  252 */     Vector<NewsgroupInfo> vector = new Vector(2048);
/*      */ 
/*      */     
/*  255 */     try (DotTerminatedMessageReader null = new DotTerminatedMessageReader(this._reader_)) {
/*  256 */       String str; while ((str = dotTerminatedMessageReader.readLine()) != null) {
/*  257 */         NewsgroupInfo newsgroupInfo = parseNewsgroupListEntry(str);
/*  258 */         if (newsgroupInfo != null) {
/*  259 */           vector.addElement(newsgroupInfo); continue;
/*      */         } 
/*  261 */         throw new MalformedServerReplyException(str);
/*      */       } 
/*      */     } 
/*      */     
/*      */     int i;
/*  266 */     if ((i = vector.size()) < 1) {
/*  267 */       return EMPTY_NEWSGROUP_INFO_ARRAY;
/*      */     }
/*      */     
/*  270 */     NewsgroupInfo[] arrayOfNewsgroupInfo = new NewsgroupInfo[i];
/*  271 */     vector.copyInto((Object[])arrayOfNewsgroupInfo);
/*      */     
/*  273 */     return arrayOfNewsgroupInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BufferedReader retrieve(int paramInt, String paramString, ArticleInfo paramArticleInfo) throws IOException {
/*  280 */     if (paramString != null) {
/*      */       
/*  282 */       if (!NNTPReply.isPositiveCompletion(sendCommand(paramInt, paramString))) {
/*  283 */         return null;
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  288 */     else if (!NNTPReply.isPositiveCompletion(sendCommand(paramInt))) {
/*  289 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  294 */     if (paramArticleInfo != null) {
/*  295 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/*  298 */     return (BufferedReader)new DotTerminatedMessageReader(this._reader_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BufferedReader retrieve(int paramInt, long paramLong, ArticleInfo paramArticleInfo) throws IOException {
/*  305 */     if (!NNTPReply.isPositiveCompletion(sendCommand(paramInt, 
/*  306 */           Long.toString(paramLong)))) {
/*  307 */       return null;
/*      */     }
/*      */     
/*  310 */     if (paramArticleInfo != null) {
/*  311 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/*  314 */     return (BufferedReader)new DotTerminatedMessageReader(this._reader_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticle(String paramString, ArticleInfo paramArticleInfo) throws IOException {
/*  361 */     return retrieve(0, paramString, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticle(String paramString) throws IOException {
/*  375 */     return retrieveArticle(paramString, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticle() throws IOException {
/*  387 */     return retrieveArticle((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticle(long paramLong, ArticleInfo paramArticleInfo) throws IOException {
/*  432 */     return retrieve(0, paramLong, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticle(long paramLong) throws IOException {
/*  444 */     return retrieveArticle(paramLong, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleHeader(String paramString, ArticleInfo paramArticleInfo) throws IOException {
/*  492 */     return retrieve(3, paramString, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticleHeader(String paramString) throws IOException {
/*  505 */     return retrieveArticleHeader(paramString, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticleHeader() throws IOException {
/*  516 */     return retrieveArticleHeader((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleHeader(long paramLong, ArticleInfo paramArticleInfo) throws IOException {
/*  562 */     return retrieve(3, paramLong, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleHeader(long paramLong) throws IOException {
/*  575 */     return retrieveArticleHeader(paramLong, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleBody(String paramString, ArticleInfo paramArticleInfo) throws IOException {
/*  623 */     return retrieve(1, paramString, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticleBody(String paramString) throws IOException {
/*  637 */     return retrieveArticleBody(paramString, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader retrieveArticleBody() throws IOException {
/*  649 */     return retrieveArticleBody((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleBody(long paramLong, ArticleInfo paramArticleInfo) throws IOException {
/*  695 */     return retrieve(1, paramLong, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleBody(long paramLong) throws IOException {
/*  707 */     return retrieveArticleBody(paramLong, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectNewsgroup(String paramString, NewsgroupInfo paramNewsgroupInfo) throws IOException {
/*  732 */     if (!NNTPReply.isPositiveCompletion(group(paramString))) {
/*  733 */       return false;
/*      */     }
/*      */     
/*  736 */     if (paramNewsgroupInfo != null) {
/*  737 */       parseGroupReply(getReplyString(), paramNewsgroupInfo);
/*      */     }
/*      */     
/*  740 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectNewsgroup(String paramString) throws IOException {
/*  751 */     return selectNewsgroup(paramString, (NewsgroupInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String listHelp() throws IOException {
/*  768 */     if (!NNTPReply.isInformational(help())) {
/*  769 */       return null;
/*      */     }
/*      */     
/*  772 */     try(StringWriter null = new StringWriter(); 
/*  773 */         DotTerminatedMessageReader null = new DotTerminatedMessageReader(this._reader_)) {
/*  774 */       Util.copyReader((Reader)dotTerminatedMessageReader, stringWriter);
/*  775 */       return stringWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] listOverviewFmt() throws IOException {
/*  787 */     if (!NNTPReply.isPositiveCompletion(sendCommand("LIST", "OVERVIEW.FMT"))) {
/*  788 */       return null;
/*      */     }
/*      */     
/*  791 */     try (DotTerminatedMessageReader null = new DotTerminatedMessageReader(this._reader_)) {
/*      */       
/*  793 */       ArrayList<String> arrayList = new ArrayList(); String str;
/*  794 */       while ((str = dotTerminatedMessageReader.readLine()) != null) {
/*  795 */         arrayList.add(str);
/*      */       }
/*  797 */       return arrayList.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectArticle(String paramString, ArticleInfo paramArticleInfo) throws IOException {
/*  829 */     if (paramString != null) {
/*  830 */       if (!NNTPReply.isPositiveCompletion(stat(paramString))) {
/*  831 */         return false;
/*      */       }
/*      */     }
/*  834 */     else if (!NNTPReply.isPositiveCompletion(stat())) {
/*  835 */       return false;
/*      */     } 
/*      */ 
/*      */     
/*  839 */     if (paramArticleInfo != null) {
/*  840 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/*  843 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectArticle(String paramString) throws IOException {
/*  854 */     return selectArticle(paramString, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectArticle(ArticleInfo paramArticleInfo) throws IOException {
/*  866 */     return selectArticle((String)null, paramArticleInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectArticle(long paramLong, ArticleInfo paramArticleInfo) throws IOException {
/*  898 */     if (!NNTPReply.isPositiveCompletion(stat(paramLong))) {
/*  899 */       return false;
/*      */     }
/*      */     
/*  902 */     if (paramArticleInfo != null) {
/*  903 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/*  906 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectArticle(long paramLong) throws IOException {
/*  916 */     return selectArticle(paramLong, (ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectPreviousArticle(ArticleInfo paramArticleInfo) throws IOException {
/*  947 */     if (!NNTPReply.isPositiveCompletion(last())) {
/*  948 */       return false;
/*      */     }
/*      */     
/*  951 */     if (paramArticleInfo != null) {
/*  952 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/*  955 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectPreviousArticle() throws IOException {
/*  963 */     return selectPreviousArticle((ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectNextArticle(ArticleInfo paramArticleInfo) throws IOException {
/*  993 */     if (!NNTPReply.isPositiveCompletion(next())) {
/*  994 */       return false;
/*      */     }
/*      */     
/*  997 */     if (paramArticleInfo != null) {
/*  998 */       parseArticlePointer(getReplyString(), paramArticleInfo);
/*      */     }
/*      */     
/* 1001 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectNextArticle() throws IOException {
/* 1010 */     return selectNextArticle((ArticleInfo)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NewsgroupInfo[] listNewsgroups() throws IOException {
/* 1036 */     if (!NNTPReply.isPositiveCompletion(list())) {
/* 1037 */       return null;
/*      */     }
/*      */     
/* 1040 */     return readNewsgroupListing();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<String> iterateNewsgroupListing() throws IOException {
/* 1061 */     if (NNTPReply.isPositiveCompletion(list())) {
/* 1062 */       return new ReplyIterator(this._reader_);
/*      */     }
/* 1064 */     throw new IOException("LIST command failed: " + getReplyString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<NewsgroupInfo> iterateNewsgroups() throws IOException {
/* 1085 */     return new NewsgroupIterator(iterateNewsgroupListing());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NewsgroupInfo[] listNewsgroups(String paramString) throws IOException {
/* 1103 */     if (!NNTPReply.isPositiveCompletion(listActive(paramString))) {
/* 1104 */       return null;
/*      */     }
/* 1106 */     return readNewsgroupListing();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<String> iterateNewsgroupListing(String paramString) throws IOException {
/* 1123 */     if (NNTPReply.isPositiveCompletion(listActive(paramString))) {
/* 1124 */       return new ReplyIterator(this._reader_);
/*      */     }
/* 1126 */     throw new IOException("LIST ACTIVE " + paramString + " command failed: " + getReplyString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<NewsgroupInfo> iterateNewsgroups(String paramString) throws IOException {
/* 1142 */     return new NewsgroupIterator(iterateNewsgroupListing(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NewsgroupInfo[] listNewNewsgroups(NewGroupsOrNewsQuery paramNewGroupsOrNewsQuery) throws IOException {
/* 1170 */     if (!NNTPReply.isPositiveCompletion(newgroups(paramNewGroupsOrNewsQuery
/* 1171 */           .getDate(), paramNewGroupsOrNewsQuery.getTime(), paramNewGroupsOrNewsQuery
/* 1172 */           .isGMT(), paramNewGroupsOrNewsQuery.getDistributions())))
/*      */     {
/* 1174 */       return null;
/*      */     }
/*      */     
/* 1177 */     return readNewsgroupListing();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<String> iterateNewNewsgroupListing(NewGroupsOrNewsQuery paramNewGroupsOrNewsQuery) throws IOException {
/* 1200 */     if (NNTPReply.isPositiveCompletion(newgroups(paramNewGroupsOrNewsQuery
/* 1201 */           .getDate(), paramNewGroupsOrNewsQuery.getTime(), paramNewGroupsOrNewsQuery
/* 1202 */           .isGMT(), paramNewGroupsOrNewsQuery.getDistributions()))) {
/* 1203 */       return new ReplyIterator(this._reader_);
/*      */     }
/* 1205 */     throw new IOException("NEWGROUPS command failed: " + getReplyString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<NewsgroupInfo> iterateNewNewsgroups(NewGroupsOrNewsQuery paramNewGroupsOrNewsQuery) throws IOException {
/* 1228 */     return new NewsgroupIterator(iterateNewNewsgroupListing(paramNewGroupsOrNewsQuery));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] listNewNews(NewGroupsOrNewsQuery paramNewGroupsOrNewsQuery) throws IOException {
/* 1260 */     if (!NNTPReply.isPositiveCompletion(newnews(paramNewGroupsOrNewsQuery.getNewsgroups(), paramNewGroupsOrNewsQuery.getDate(), paramNewGroupsOrNewsQuery.getTime(), paramNewGroupsOrNewsQuery
/* 1261 */           .isGMT(), paramNewGroupsOrNewsQuery.getDistributions()))) {
/* 1262 */       return null;
/*      */     }
/*      */     
/* 1265 */     Vector<String> vector = new Vector();
/* 1266 */     try (DotTerminatedMessageReader null = new DotTerminatedMessageReader(this._reader_)) {
/*      */       String str;
/*      */       
/* 1269 */       while ((str = dotTerminatedMessageReader.readLine()) != null) {
/* 1270 */         vector.addElement(str);
/*      */       }
/*      */     } 
/*      */     
/* 1274 */     int i = vector.size();
/* 1275 */     if (i < 1) {
/* 1276 */       return NetConstants.EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 1279 */     String[] arrayOfString = new String[i];
/* 1280 */     vector.copyInto((Object[])arrayOfString);
/*      */     
/* 1282 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<String> iterateNewNews(NewGroupsOrNewsQuery paramNewGroupsOrNewsQuery) throws IOException {
/* 1309 */     if (NNTPReply.isPositiveCompletion(newnews(paramNewGroupsOrNewsQuery
/* 1310 */           .getNewsgroups(), paramNewGroupsOrNewsQuery.getDate(), paramNewGroupsOrNewsQuery.getTime(), paramNewGroupsOrNewsQuery
/* 1311 */           .isGMT(), paramNewGroupsOrNewsQuery.getDistributions()))) {
/* 1312 */       return new ReplyIterator(this._reader_);
/*      */     }
/* 1314 */     throw new IOException("NEWNEWS command failed: " + getReplyString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean completePendingCommand() throws IOException {
/* 1351 */     return NNTPReply.isPositiveCompletion(getReply());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer postArticle() throws IOException {
/* 1394 */     if (!NNTPReply.isPositiveIntermediate(post())) {
/* 1395 */       return null;
/*      */     }
/*      */     
/* 1398 */     return (Writer)new DotTerminatedMessageWriter(this._writer_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer forwardArticle(String paramString) throws IOException {
/* 1404 */     if (!NNTPReply.isPositiveIntermediate(ihave(paramString))) {
/* 1405 */       return null;
/*      */     }
/*      */     
/* 1408 */     return (Writer)new DotTerminatedMessageWriter(this._writer_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean logout() throws IOException {
/* 1423 */     return NNTPReply.isPositiveCompletion(quit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean authenticate(String paramString1, String paramString2) throws IOException {
/* 1440 */     int i = authinfoUser(paramString1);
/*      */     
/* 1442 */     if (i == 381) {
/*      */       
/* 1444 */       i = authinfoPass(paramString2);
/*      */       
/* 1446 */       if (i == 281) {
/*      */         
/* 1448 */         this._isAllowedToPost = true;
/* 1449 */         return true;
/*      */       } 
/*      */     } 
/* 1452 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BufferedReader retrieveArticleInfo(String paramString) throws IOException {
/* 1469 */     if (!NNTPReply.isPositiveCompletion(xover(paramString))) {
/* 1470 */       return null;
/*      */     }
/*      */     
/* 1473 */     return (BufferedReader)new DotTerminatedMessageReader(this._reader_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleInfo(long paramLong) throws IOException {
/* 1485 */     return retrieveArticleInfo(Long.toString(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveArticleInfo(long paramLong1, long paramLong2) throws IOException {
/* 1501 */     return 
/* 1502 */       retrieveArticleInfo(paramLong1 + "-" + paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterable<Article> iterateArticleInfo(long paramLong1, long paramLong2) throws IOException {
/* 1519 */     BufferedReader bufferedReader = retrieveArticleInfo(paramLong1, paramLong2);
/* 1520 */     if (bufferedReader == null) {
/* 1521 */       throw new IOException("XOVER command failed: " + getReplyString());
/*      */     }
/*      */     
/* 1524 */     return new ArticleIterator(new ReplyIterator(bufferedReader, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BufferedReader retrieveHeader(String paramString1, String paramString2) throws IOException {
/* 1542 */     if (!NNTPReply.isPositiveCompletion(xhdr(paramString1, paramString2))) {
/* 1543 */       return null;
/*      */     }
/*      */     
/* 1546 */     return (BufferedReader)new DotTerminatedMessageReader(this._reader_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveHeader(String paramString, long paramLong) throws IOException {
/* 1560 */     return retrieveHeader(paramString, Long.toString(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BufferedReader retrieveHeader(String paramString, long paramLong1, long paramLong2) throws IOException {
/* 1577 */     return 
/* 1578 */       retrieveHeader(paramString, paramLong1 + "-" + paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveHeader(String paramString, int paramInt1, int paramInt2) throws IOException {
/* 1602 */     return retrieveHeader(paramString, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleInfo(int paramInt1, int paramInt2) throws IOException {
/* 1614 */     return retrieveArticleInfo(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveHeader(String paramString, int paramInt) throws IOException {
/* 1626 */     return retrieveHeader(paramString, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectArticle(int paramInt, ArticlePointer paramArticlePointer) throws IOException {
/* 1638 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1639 */     boolean bool = selectArticle(paramInt, articleInfo);
/* 1640 */     ai2ap(articleInfo, paramArticlePointer);
/* 1641 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleInfo(int paramInt) throws IOException {
/* 1652 */     return retrieveArticleInfo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectArticle(int paramInt) throws IOException {
/* 1663 */     return selectArticle(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleHeader(int paramInt) throws IOException {
/* 1674 */     return retrieveArticleHeader(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleHeader(int paramInt, ArticlePointer paramArticlePointer) throws IOException {
/* 1686 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1687 */     BufferedReader bufferedReader = retrieveArticleHeader(paramInt, articleInfo);
/* 1688 */     ai2ap(articleInfo, paramArticlePointer);
/* 1689 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleBody(int paramInt) throws IOException {
/* 1700 */     return retrieveArticleBody(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticle(int paramInt, ArticlePointer paramArticlePointer) throws IOException {
/* 1713 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1714 */     BufferedReader bufferedReader = retrieveArticle(paramInt, articleInfo);
/* 1715 */     ai2ap(articleInfo, paramArticlePointer);
/* 1716 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticle(int paramInt) throws IOException {
/* 1728 */     return retrieveArticle(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleBody(int paramInt, ArticlePointer paramArticlePointer) throws IOException {
/* 1740 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1741 */     BufferedReader bufferedReader = retrieveArticleBody(paramInt, articleInfo);
/* 1742 */     ai2ap(articleInfo, paramArticlePointer);
/* 1743 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticle(String paramString, ArticlePointer paramArticlePointer) throws IOException {
/* 1756 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1757 */     BufferedReader bufferedReader = retrieveArticle(paramString, articleInfo);
/* 1758 */     ai2ap(articleInfo, paramArticlePointer);
/* 1759 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleBody(String paramString, ArticlePointer paramArticlePointer) throws IOException {
/* 1772 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1773 */     BufferedReader bufferedReader = retrieveArticleBody(paramString, articleInfo);
/* 1774 */     ai2ap(articleInfo, paramArticlePointer);
/* 1775 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Reader retrieveArticleHeader(String paramString, ArticlePointer paramArticlePointer) throws IOException {
/* 1788 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1789 */     BufferedReader bufferedReader = retrieveArticleHeader(paramString, articleInfo);
/* 1790 */     ai2ap(articleInfo, paramArticlePointer);
/* 1791 */     return bufferedReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectArticle(String paramString, ArticlePointer paramArticlePointer) throws IOException {
/* 1804 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1805 */     boolean bool = selectArticle(paramString, articleInfo);
/* 1806 */     ai2ap(articleInfo, paramArticlePointer);
/* 1807 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectArticle(ArticlePointer paramArticlePointer) throws IOException {
/* 1819 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1820 */     boolean bool = selectArticle(articleInfo);
/* 1821 */     ai2ap(articleInfo, paramArticlePointer);
/* 1822 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectNextArticle(ArticlePointer paramArticlePointer) throws IOException {
/* 1834 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1835 */     boolean bool = selectNextArticle(articleInfo);
/* 1836 */     ai2ap(articleInfo, paramArticlePointer);
/* 1837 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean selectPreviousArticle(ArticlePointer paramArticlePointer) throws IOException {
/* 1849 */     ArticleInfo articleInfo = ap2ai(paramArticlePointer);
/* 1850 */     boolean bool = selectPreviousArticle(articleInfo);
/* 1851 */     ai2ap(articleInfo, paramArticlePointer);
/* 1852 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ArticleInfo ap2ai(ArticlePointer paramArticlePointer) {
/* 1858 */     if (paramArticlePointer == null) {
/* 1859 */       return null;
/*      */     }
/* 1861 */     return new ArticleInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void ai2ap(ArticleInfo paramArticleInfo, ArticlePointer paramArticlePointer) {
/* 1867 */     if (paramArticlePointer != null) {
/* 1868 */       paramArticlePointer.articleId = paramArticleInfo.articleId;
/* 1869 */       paramArticlePointer.articleNumber = (int)paramArticleInfo.articleNumber;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\NNTPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */