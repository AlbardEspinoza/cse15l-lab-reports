# Lab Report 3

## find -- walk a file hierarchy

* **Description:** The find utility recursively descends the directory tree for each path listed, evaluating an
  expression (composed of the ``primaries'' and ``operands'' listed below) in terms of each file in
  the tree.

* **Options:**

  * **-iname _pattern_**  
    
    * Displays files or directories if the last component of the pathname being examined matches _pattern_.  Special shell pattern matching characters `(``['', ``]'', ``*'', and ``?'')` may be used as part of pattern.  These characters may be matched explicitly by escaping them with a backslash `(``\'')`. **Source: man page for the find command.**
    
  * **-empty:** 
  
    * Displays the file(s) or directory(ies) that are empty. **Source: man page for the find command.**
  
  * **-perm _[-|+]mode_:**
  
    *  The mode may be either symbolic (see chmod(1)) or an octal number.  If the mode is symbolic, a starting value of zero is assumed and the mode sets or clears permissions without regard to the process' file mode creation mask.  If the mode is octal, only bits `07777 (S_ISUID | S_ISGID | S_ISTXT | S_IRWXU | S_IRWXG | S_IRWXO)` of the file's mode bits participate in the comparison.  If the mode is preceded by a dash `(``-'')`, this primary evaluates to true if at least all of the bits in the mode are set in the file's mode bits.  If the mode is preceded by a plus `(``+'')`, this primary evaluates to true if any of the bits in the mode are set in the file's mode bits.  Otherwise, this primary evaluates to true if the bits in the mode exactly match the file's mode bits.  Note, the first character of a symbolic mode may not be a dash `(``-'')`. **Source: man page for the find command.**
  
  * **-size _n_:**
  
    * True if the file's size, rounded up, in 512-byte blocks is n.  If n is followed by a c, then the primary is true if the file's size is n bytes (characters).  Similarly if n is followed by a scale indicator then the file's size is compared to _n_ scaled as:
  
      * **k:** kilobytes (1024 bytes)
      * **M:** megabytes (1024 kilobytes)
      * **G: ** gigabytes (1024 megabytes)
      * **T: ** terabytes (1024 gigabytes)
      * **P: ** petabytes (1024 terabytes)
  
      **Source: man page for the find command.**

* **Examples:**
  * **-iname _pattern_:**
    * 