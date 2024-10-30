package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFileEntryParser;

public interface FTPFileEntryParserFactory {
  FTPFileEntryParser createFileEntryParser(String paramString) throws ParserInitializationException;
  
  FTPFileEntryParser createFileEntryParser(FTPClientConfig paramFTPClientConfig) throws ParserInitializationException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\FTPFileEntryParserFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */