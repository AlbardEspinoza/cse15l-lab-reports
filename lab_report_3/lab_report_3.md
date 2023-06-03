# Lab Report 3

## find -- walk a file hierarchy

* **Description:** The find utility recursively descends the directory tree for each path listed, evaluating an
  expression (composed of the ``primaries'' and ``operands'' listed below) in terms of each file in
  the tree.

* **Options:**

  * **-iname _pattern_**  
    
    * Displays files or directories if the last component of the pathname being examined matches _pattern_.  Special shell pattern matching characters `(``['', ``]'', ``*'', and ``?'')` may be used as part of pattern.  These characters may be matched explicitly by escaping them with a backslash `(``\'')`. Match is case-insensitive. **Source: man page for the find command.**
    
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

* **Examples(current working directory is docsearch):**

  * **-iname _pattern_:**

    * ```bash
      ➜ docsearch git:(main) find technical/government -iname "*aid*"
      technical/government/About_LSC/ONTARIO_LEGAL_AID_SERIES.txt
      technical/government/Media/Legal-aid_chief.txt
      technical/government/Media/Providing_Legal_Aid.txt
      technical/government/Media/Legal_Aid_in_Clay_County.txt
      technical/government/Media/Poor_Lacking_Legal_Aid.txt
      technical/government/Media/Workers_aid_center.txt
      technical/government/Media/Coup_Reshapes_Legal_Aid.txt
      technical/government/Media/Legal_Aid_looks_to_legislators.txt
      technical/government/Media/Marylands_Legal_Aid.txt
      technical/government/Media/Legal_Aid_Society.txt
      technical/government/Media/Domestic_violence_aid.txt
      technical/government/Media/Legal_Aid_attorney.txt
      technical/government/Media/less_legal_aid.txt
      technical/government/Media/Bridging_legal_aid_gap.txt
      technical/government/Media/Legal_Aid_campaign.txt
      technical/government/Media/Aid_Gets_7_Million.txt
      ```

      My intetion in this example was to get all the aid documentation under the technical/government directory. Unfortunately, I did not know exactly what the case for each letter was in each file. Thankfully, **find -iname** is case-insensitive which allowed to just diplay the pattern **"`*aid*`"** and it displayed all the files containing that pattern regardless of the case.