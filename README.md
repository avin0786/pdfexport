# Getting Started

### Reference Documentation
.Net framework installation

https://www.microsoft.com/en-in/download/details.aspx?id=42642

Download My Sql
https://filehippo.com/download_mysql/

mvn spring-boot:run


Then run mvn clean install command on  project

PDFMiner
PDFMiner is a text extraction tool for PDF documents.

Build Status PyPI

Warning: As of 2020, PDFMiner is not actively maintained. The code still works, but this project is largely dormant. For the active project, check out its fork pdfminer.six.

Features:
Pure Python (3.6 or above).
Supports PDF-1.7. (well, almost)
Obtains the exact location of text as well as other layout information (fonts, etc.).
Performs automatic layout analysis.
Can convert PDF into other formats (HTML/XML).
Can extract an outline (TOC).
Can extract tagged contents.
Supports basic encryption (RC4 and AES).
Supports various font types (Type1, TrueType, Type3, and CID).
Supports CJK languages and vertical writing scripts.
Has an extensible PDF parser that can be used for other purposes.
How to Use:
> pip install pdfminer
> pdf2txt.py samples/simple1.pdf
Command Line Syntax:
pdf2txt.py
pdf2txt.py extracts all the texts that are rendered programmatically. It also extracts the corresponding locations, font names, font sizes, writing direction (horizontal or vertical) for each text segment. It does not recognize text in images. A password needs to be provided for restricted PDF documents.

> pdf2txt.py [-P password] [-o output] [-t text|html|xml|tag]
             [-O output_dir] [-c encoding] [-s scale] [-R rotation]
             [-Y normal|loose|exact] [-p pagenos] [-m maxpages]
             [-S] [-C] [-n] [-A] [-V]
             [-M char_margin] [-L line_margin] [-W word_margin]
             [-F boxes_flow] [-d]
             input.pdf ...
-P password : PDF password.
-o output : Output file name.
-t text|html|xml|tag : Output type. (default: automatically inferred from the output file name.)
-O output_dir : Output directory for extracted images.
-c encoding : Output encoding. (default: utf-8)
-s scale : Output scale.
-R rotation : Rotates the page in degree.
-Y normal|loose|exact : Specifies the layout mode. (only for HTML output.)
-p pagenos : Processes certain pages only.
-m maxpages : Limits the number of maximum pages to process.
-S : Strips control characters.
-C : Disables resource caching.
-n : Disables layout analysis.
-A : Applies layout analysis for all texts including figures.
-V : Automatically detects vertical writing.
-M char_margin : Speficies the char margin.
-W word_margin : Speficies the word margin.
-L line_margin : Speficies the line margin.
-F boxes_flow : Speficies the box flow ratio.
-d : Turns on Debug output.