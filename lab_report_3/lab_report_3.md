# Lab Report 3

## find -- walk a file hierarchy

* **Description:** The find utility recursively descends the directory tree for each path listed, evaluating an
  expression (composed of primaries'' and operands'') in terms of each file in
  the tree.

* **Options:**

  * **-iname _pattern_**  
    
    * Displays files or directories if the last component of the pathname being examined matches _pattern_.  Special shell pattern matching characters `(``['', ``]'', ``*'', and ``?'')` may be used as part of pattern.  These characters may be matched explicitly by escaping them with a backslash `(``\'')`. Match is case-insensitive. **Source: man page for the find command.**
    
  * **-empty:** 
  
    * Displays the file(s) or directory(ies) that are empty. **Source: man page for the find command.**
  
  * **-perm _`[-|+]`mode_:**
  
    *  The mode may be either symbolic (see chmod(1)) or an octal number.  If the mode is symbolic, a starting value of zero is assumed and the mode sets or clears permissions without regard to the process' file mode creation mask.  If the mode is octal, only bits `07777 (S_ISUID | S_ISGID | S_ISTXT | S_IRWXU | S_IRWXG | S_IRWXO)` of the file's mode bits participate in the comparison.  If the mode is preceded by a dash (-), this primary evaluates to true if at least all of the bits in the mode are set in the file's mode bits.  If the mode is preceded by a plus (+), this primary evaluates to true if any of the bits in the mode are set in the file's mode bits.  Otherwise, this primary evaluates to true if the bits in the mode exactly match the file's mode bits.  Note, the first character of a symbolic mode may not be a dash (-). **Source: man page for the find command.**
  
  * **-size _n_:**
  
    * Displays file(s) if the file's size, rounded up, in 512-byte blocks is n.  If n is followed by a c, then the primary is true if the file's size is n bytes (characters).  Similarly if n is followed by a scale indicator then the file's size is compared to _n_ scaled as:
  
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

      My intetion in this example was to get all the aid documentation under the technical/government directory. Unfortunately, I did not know exactly what the case for each letter was in each file. Thankfully, **find -iname** is case-insensitive which allowed to just diplay the pattern **"`*aid*`"** and it displayed all the files containing that pattern regardless of the case. **SOURCE: [phind.com](phind.com)** 

    * ```bash
      ➜  docsearch git:(main) find technical -name "*lawsuit*"
      ➜  docsearch git:(main)
      ```

      My intention in  this example was to find any possible files that were part of a lawsuit. Thankfully the command did not find any lawsuit files in any of the directories under technical :relieved:. **SOURCE: [phind.com](phind.com)** 

  * **-empty:** 

    * ```bash
      ➜  docsearch git:(main) find technical -empty
      ➜  docsearch git:(main)
      ```

      My intention in this example was to see if we han any uncesseray files. So I decided to look up any files that were empty. Thankfully I did not fing any so I did not have to remove any unecessary files. **SOURCE: [phind.com](phind.com)** 

    * ```bash
      ➜  docsearch git:(main) touch technical/biomed/empty_file_example.txt
      ➜  docsearch git:(main) ✗ find technical -empty
      technical/biomed/empty_file_example.txt
      ➜  docsearch git:(main) ✗
      ```

      In this example I tried to demonstrate how the find example displayed an empty file. I first created an empty file in technical/biomed/ then I used the find command with the -empty option to see if it would be able to find and display it. It fortunately found it and displayed the path from my current directory up until the file. **SOURCE: [phind.com](phind.com)** 

  * **-perm _[-|+]mode_:**

    * ```bash
      ➜  docsearch git:(main) find technical -perm -u=w
      technical
      technical/government
      technical/government/About_LSC
      technical/government/Env_Prot_Agen
      technical/government/Alcohol_Problems
      technical/government/Gen_Account_Office
      technical/government/Post_Rate_Comm
      technical/government/Media
      technical/plos
      technical/plos/pmed.0020273.txt
      technical/plos/journal.pbio.0030032.txt
      technical/plos/pmed.0020065.txt
      technical/plos/pmed.0020071.txt
      technical/plos/pmed.0020059.txt
      technical/plos/pmed.0010039.txt
      technical/plos/journal.pbio.0020354.txt
      technical/plos/pmed.0010010.txt
      technical/plos/journal.pbio.0020156.txt
      technical/plos/pmed.0020104.txt
      technical/plos/pmed.0020272.txt
      technical/plos/pmed.0020258.txt
      technical/plos/pmed.0020099.txt
      technical/plos/journal.pbio.0020140.txt
      technical/plos/journal.pbio.0020183.txt
      technical/plos/journal.pbio.0020430.txt
      technical/plos/journal.pbio.0020394.txt
      technical/plos/journal.pbio.0020431.txt
      technical/plos/journal.pbio.0020419.txt
      technical/plos/pmed.0010013.txt
      technical/plos/pmed.0020113.txt
      technical/plos/journal.pbio.0020169.txt
      technical/plos/pmed.0020098.txt
      technical/plos/journal.pbio.0020035.txt
      technical/plos/pmed.0020067.txt
      technical/plos/pmed.0020073.txt
      technical/plos/journal.pbio.0030024.txt
      technical/plos/journal.pbio.0020223.txt
      technical/plos/pmed.0020249.txt
      technical/plos/pmed.0020275.txt
      technical/plos/journal.pbio.0020019.txt
      technical/plos/pmed.0020088.txt
      technical/plos/journal.pbio.0020145.txt
      technical/plos/pmed.0020103.txt
      technical/plos/pmed.0020117.txt
      technical/plos/journal.pbio.0020353.txt
      technical/plos/journal.pbio.0020347.txt
      technical/plos/journal.pbio.0020420.txt
      technical/plos/journal.pbio.0020346.txt
      technical/plos/journal.pbio.0020187.txt
      technical/plos/pmed.0020116.txt
      technical/plos/pmed.0020102.txt
      technical/plos/journal.pbio.0020150.txt
      technical/plos/pmed.0020062.txt
      technical/plos/pmed.0020274.txt
      technical/plos/journal.pbio.0020232.txt
      technical/plos/journal.pbio.0030021.txt
      technical/plos/journal.pbio.0020224.txt
      technical/plos/pmed.0020048.txt
      technical/plos/pmed.0020060.txt
      technical/plos/pmed.0020074.txt
      technical/plos/journal.pbio.0020146.txt
      technical/plos/pmed.0020114.txt
      technical/plos/pmed.0010028.txt
      technical/plos/journal.pbio.0020350.txt
      technical/plos/journal.pbio.0020190.txt
      technical/plos/pmed.0010029.txt
      technical/plos/pmed.0020115.txt
      technical/plos/journal.pbio.0020147.txt
      technical/plos/pmed.0020075.txt
      technical/plos/pmed.0020061.txt
      technical/plos/pmed.0020210.txt
      technical/plos/pmed.0020238.txt
      technical/plos/journal.pbio.0030051.txt
      technical/plos/journal.pbio.0020068.txt
      technical/plos/journal.pbio.0020054.txt
      technical/plos/journal.pbio.0020040.txt
      technical/plos/pmed.0010066.txt
      technical/plos/journal.pbio.0030131.txt
      technical/plos/journal.pbio.0020337.txt
      technical/plos/pmed.0020198.txt
      technical/plos/pmed.0010067.txt
      technical/plos/journal.pbio.0020121.txt
      technical/plos/pmed.0020007.txt
      technical/plos/journal.pbio.0030050.txt
      technical/plos/pmed.0020239.txt
      technical/plos/journal.pbio.0020241.txt
      technical/plos/pmed.0020005.txt
      technical/plos/journal.pbio.0020043.txt
      technical/plos/pmed.0020039.txt
      technical/plos/pmed.0010071.txt
      technical/plos/journal.pbio.0030127.txt
      technical/plos/pmed.0010058.txt
      technical/plos/pmed.0010070.txt
      technical/plos/pmed.0010064.txt
      technical/plos/pmed.0020158.txt
      technical/plos/journal.pbio.0020042.txt
      technical/plos/journal.pbio.0020297.txt
      technical/plos/pmed.0020206.txt
      technical/plos/pmed.0020212.txt
      technical/plos/pmed.0020216.txt
      technical/plos/journal.pbio.0030094.txt
      technical/plos/journal.pbio.0020046.txt
      technical/plos/pmed.0020028.txt
      technical/plos/journal.pbio.0020052.txt
      technical/plos/pmed.0020148.txt
      technical/plos/pmed.0020160.txt
      technical/plos/pmed.0010048.txt
      technical/plos/pmed.0010060.txt
      technical/plos/journal.pbio.0030137.txt
      technical/plos/journal.pbio.0030136.txt
      technical/plos/pmed.0010061.txt
      technical/plos/pmed.0010049.txt
      technical/plos/pmed.0020161.txt
      technical/plos/journal.pbio.0020127.txt
      technical/plos/pmed.0020149.txt
      technical/plos/journal.pbio.0020133.txt
      technical/plos/pmed.0020015.txt
      technical/plos/journal.pbio.0020053.txt
      technical/plos/journal.pbio.0020047.txt
      technical/plos/pmed.0020203.txt
      technical/plos/journal.pbio.0030056.txt
      technical/plos/pmed.0020201.txt
      technical/plos/journal.pbio.0030097.txt
      technical/plos/pmed.0020017.txt
      technical/plos/journal.pbio.0020125.txt
      technical/plos/journal.pbio.0020440.txt
      technical/plos/pmed.0010062.txt
      technical/plos/pmed.0020189.txt
      technical/plos/pmed.0020162.txt
      technical/plos/pmed.0020016.txt
      technical/plos/pmed.0020002.txt
      technical/plos/pmed.0020200.txt
      technical/plos/pmed.0020231.txt
      technical/plos/journal.pbio.0020263.txt
      technical/plos/pmed.0020027.txt
      technical/plos/pmed.0020033.txt
      technical/plos/journal.pbio.0020101.txt
      technical/plos/pmed.0010047.txt
      technical/plos/journal.pbio.0030105.txt
      technical/plos/journal.pbio.0020302.txt
      technical/plos/pmed.0010046.txt
      technical/plos/pmed.0010052.txt
      technical/plos/pmed.0020191.txt
      technical/plos/journal.pbio.0020100.txt
      technical/plos/pmed.0020146.txt
      technical/plos/journal.pbio.0020262.txt
      technical/plos/journal.pbio.0030065.txt
      technical/plos/journal.pbio.0020276.txt
      technical/plos/pmed.0020232.txt
      technical/plos/pmed.0020226.txt
      technical/plos/pmed.0020024.txt
      technical/plos/pmed.0020018.txt
      technical/plos/pmed.0020144.txt
      technical/plos/pmed.0020150.txt
      technical/plos/journal.pbio.0020116.txt
      technical/plos/pmed.0020187.txt
      technical/plos/pmed.0010050.txt
      technical/plos/pmed.0010051.txt
      technical/plos/pmed.0020192.txt
      technical/plos/pmed.0010045.txt
      technical/plos/pmed.0020145.txt
      technical/plos/pmed.0020019.txt
      technical/plos/journal.pbio.0020063.txt
      technical/plos/journal.pbio.0030076.txt
      technical/plos/journal.pbio.0030062.txt
      technical/plos/pmed.0020237.txt
      technical/plos/journal.pbio.0020067.txt
      technical/plos/pmed.0020009.txt
      technical/plos/journal.pbio.0020073.txt
      technical/plos/pmed.0020035.txt
      technical/plos/pmed.0020021.txt
      technical/plos/journal.pbio.0020113.txt
      technical/plos/pmed.0020155.txt
      technical/plos/pmed.0010069.txt
      technical/plos/pmed.0010041.txt
      technical/plos/pmed.0020182.txt
      technical/plos/pmed.0020196.txt
      technical/plos/journal.pbio.0020311.txt
      technical/plos/journal.pbio.0030102.txt
      technical/plos/journal.pbio.0020310.txt
      technical/plos/pmed.0020197.txt
      technical/plos/pmed.0010068.txt
      technical/plos/pmed.0020140.txt
      technical/plos/journal.pbio.0020112.txt
      technical/plos/pmed.0020020.txt
      technical/plos/pmed.0020034.txt
      technical/plos/pmed.0020236.txt
      technical/plos/journal.pbio.0020272.txt
      technical/plos/pmed.0020208.txt
      technical/plos/journal.pbio.0020064.txt
      technical/plos/pmed.0020022.txt
      technical/plos/pmed.0020036.txt
      technical/plos/pmed.0010056.txt
      technical/plos/pmed.0020195.txt
      technical/plos/pmed.0010042.txt
      technical/plos/pmed.0020181.txt
      technical/plos/journal.pbio.0020306.txt
      technical/plos/journal.pbio.0030129.txt
      technical/plos/journal.pbio.0020307.txt
      technical/plos/pmed.0020180.txt
      technical/plos/pmed.0020194.txt
      technical/plos/pmed.0020157.txt
      technical/plos/journal.pbio.0020105.txt
      technical/plos/pmed.0020023.txt
      technical/plos/journal.pbio.0020071.txt
      technical/plos/pmed.0020235.txt
      technical/plos/journal.pbio.0020267.txt
      technical/plos/pmed.0020209.txt
      technical/plos/pmed.0020246.txt
      technical/plos/journal.pbio.0020228.txt
      technical/plos/journal.pbio.0020214.txt
      technical/plos/pmed.0020050.txt
      technical/plos/pmed.0020118.txt
      technical/plos/pmed.0010030.txt
      technical/plos/pmed.0010024.txt
      technical/plos/journal.pbio.0020348.txt
      technical/plos/journal.pbio.0020406.txt
      technical/plos/pmed.0010025.txt
      technical/plos/pmed.0020086.txt
      technical/plos/pmed.0020045.txt
      technical/plos/journal.pbio.0020215.txt
      technical/plos/pmed.0020247.txt
      technical/plos/pmed.0020047.txt
      technical/plos/journal.pbio.0020001.txt
      technical/plos/pmed.0020090.txt
      technical/plos/journal.pbio.0020161.txt
      technical/plos/journal.pbio.0020439.txt
      technical/plos/journal.pbio.0020404.txt
      technical/plos/pmed.0010026.txt
      technical/plos/journal.pbio.0020148.txt
      technical/plos/pmed.0020085.txt
      technical/plos/pmed.0020091.txt
      technical/plos/journal.pbio.0020028.txt
      technical/plos/journal.pbio.0020216.txt
      technical/plos/pmed.0020278.txt
      technical/plos/pmed.0020268.txt
      technical/plos/journal.pbio.0020206.txt
      technical/plos/journal.pbio.0020010.txt
      technical/plos/journal.pbio.0020164.txt
      technical/plos/pmed.0010022.txt
      technical/plos/pmed.0010036.txt
      technical/plos/journal.pbio.0020400.txt
      technical/plos/journal.pbio.0020401.txt
      technical/plos/pmed.0010023.txt
      technical/plos/pmed.0020123.txt
      technical/plos/pmed.0020094.txt
      technical/plos/journal.pbio.0020213.txt
      technical/plos/pmed.0020257.txt
      technical/plos/journal.pbio.0020013.txt
      technical/plos/pmed.0020055.txt
      technical/plos/pmed.0020082.txt
      technical/plos/pmed.0010021.txt
      technical/plos/pmed.0010034.txt
      technical/plos/pmed.0010008.txt
      technical/plos/pmed.0020120.txt
      technical/plos/journal.pbio.0020172.txt
      technical/plos/pmed.0020040.txt
      technical/plos/pmed.0020068.txt
      technical/plos/journal.pbio.0020012.txt
      technical/plos/pmed.0020281.txt
      technical/plos/pmed.0020242.txt
      technical/biomed
      technical/911report
      ➜  docsearch git:(main)
      ```

      In this example what I inteded was to display all the files for which my user has permission to write to the file. This is extremely useful since it allows you visualize which files can be modified by you within the path.  The u=w stands for user=write meaning user has write permissions on file. **SOURCE: [phind.com](phind.com)** 

    * ```bash
      ➜  docsearch git:(main) find technical ! -perm -u=w
      technical/911report/chapter-13.4.txt
      technical/911report/chapter-13.5.txt
      technical/911report/chapter-13.1.txt
      technical/911report/chapter-13.2.txt
      technical/911report/chapter-13.3.txt
      technical/911report/chapter-3.txt
      technical/911report/chapter-2.txt
      technical/911report/chapter-1.txt
      technical/911report/chapter-5.txt
      technical/911report/chapter-6.txt
      technical/911report/chapter-7.txt
      technical/911report/chapter-9.txt
      technical/911report/chapter-8.txt
      technical/911report/preface.txt
      technical/911report/chapter-12.txt
      technical/911report/chapter-10.txt
      technical/911report/chapter-11.txt
      ➜  docsearch git:(main)
      ```
    
      In this example I did the inverse of the last example, instead of finding the files for which my user has permission to write to I tried to find the files fow which my user does not have permission to write to. This is very helpful becaue it allows you to visualize which files you don't have access to and determine why is that the case or if restriciting writing permission was made in error. **SOURCE: [phind.com](phind.com)** 
    
  *   **-size _n_:**
      
    * ```bash
      ➜  docsearch git:(main) find technical -size +70k
      technical/government/About_LSC/commission_report.txt
      technical/government/About_LSC/State_Planning_Report.txt
      technical/government/Env_Prot_Agen/multi102902.txt
      technical/government/Env_Prot_Agen/ctf7-10.txt
      technical/government/Env_Prot_Agen/ctf1-6.txt
      technical/government/Env_Prot_Agen/ctm4-10.txt
      technical/government/Env_Prot_Agen/atx1-6.txt
      technical/government/Env_Prot_Agen/bill.txt
      technical/government/Env_Prot_Agen/tech_adden.txt
      technical/government/Alcohol_Problems/Session3-PDF.txt
      technical/government/Alcohol_Problems/Session4-PDF.txt
      technical/government/Gen_Account_Office/d0269g.txt
      technical/government/Gen_Account_Office/Testimony_cg00010t.txt
      technical/government/Gen_Account_Office/GovernmentAuditingStandards_yb2002ed.txt
      technical/government/Gen_Account_Office/Sept27-2002_d02966.txt
      technical/government/Gen_Account_Office/d01376g.txt
      technical/government/Gen_Account_Office/Statements_Feb28-1997_volume.txt
      technical/government/Gen_Account_Office/pe1019.txt
      technical/government/Gen_Account_Office/gg96118.txt
      technical/government/Gen_Account_Office/July11-2001_gg00172r.txt
      technical/government/Gen_Account_Office/d01591sp.txt
      technical/government/Gen_Account_Office/Oct15-2001_d0224.txt
      technical/government/Gen_Account_Office/im814.txt
      technical/government/Gen_Account_Office/ai00134.txt
      technical/government/Gen_Account_Office/ai9868.txt
      technical/government/Gen_Account_Office/May1998_ai98068.txt
      technical/government/Gen_Account_Office/d02701.txt
      technical/government/Post_Rate_Comm/Mitchell_6-17-Mit.txt
      technical/biomed/gb-2002-3-7-research0036.txt
      technical/biomed/1472-6904-2-5.txt
      technical/biomed/gb-2002-3-11-research0059.txt
      technical/biomed/1472-6807-3-1.txt
      technical/biomed/gb-2002-3-12-research0086.txt
      technical/biomed/gb-2002-3-12-research0083.txt
      technical/biomed/1476-511X-1-2.txt
      technical/biomed/1471-2105-3-18.txt
      technical/biomed/1471-2202-3-1.txt
      technical/biomed/1472-6882-1-10.txt
      technical/biomed/1471-2105-3-2.txt
      technical/biomed/1476-069X-2-9.txt
      technical/911report/chapter-13.4.txt
      technical/911report/chapter-13.5.txt
      technical/911report/chapter-13.1.txt
      technical/911report/chapter-13.2.txt
      technical/911report/chapter-13.3.txt
      technical/911report/chapter-3.txt
      technical/911report/chapter-2.txt
      technical/911report/chapter-1.txt
      technical/911report/chapter-5.txt
      technical/911report/chapter-6.txt
      technical/911report/chapter-7.txt
      technical/911report/chapter-9.txt
      technical/911report/chapter-8.txt
      technical/911report/chapter-12.txt
      ➜  docsearch git:(main)
      ```
      
      In this example what I intended was to display all the files that were above 70 kilobytes. This is helpful since it allows you to filter the files that have more content. **SOURCE: [phind.com](phind.com)** 
      
    * ```bash
      ➜  docsearch git:(main) find technical -size +100M
      ➜  docsearch git:(main)
      ```
      
      In this example what I intended was to display the files that were above 100 megabytes. This is very useful since usually text files that are above 100 megabytes are considered heavy. If you're low on storage in your computer and also if you don't need to have those heavy files on hand you can filter the withthe previous command, save them on Google drive or any remote storage and delete the files from your local storage. **SOURCE: [phind.com](phind.com)** 
      
        
