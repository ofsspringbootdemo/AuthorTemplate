INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Book', 'Template type to publish new Book', 'Active', LAST_INSERT_ID() );

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Conference', 'Template type to publish new Conference', 'Active', LAST_INSERT_ID() );

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Transactions, Journals and Letters', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID() );

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Magazines', 'Template type to publish new Magazines', 'Active', LAST_INSERT_ID() );


---------------- Scenario#1 Verify the publication type with only one default template --------------------
---------------- BOOKS --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'Word', 'Template for books.doc', 'Please use this template for books in word format', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Book'));


---------------- Scenario#2 Verify the publication type with more than one format --------------------
---------------- CONFERENCE --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'Word', 'Template for Conference.doc', 'Please use this template for Conference in word format', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Conference'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'Latex', 'Template for Conference.zip', 'Please use this template for Conference in latex format', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Conference'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'LaTeX for Unix', 'cs_template_latex for Conference.tar', 'Please use this template for Conference in latex for Unix format', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Conference'));

---------------- Scenario#3 Verify the with publication type -> publication name with only one template. --------------------
---------------- IEEE Open Journal of Antennas and Propagation --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Open Journal of Antennas and Propagation', '', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

 INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'LaTeX', 'IEEE-open-journal-propagation-template.zip', 'Please use this template when writing an original research article for IEEE Open Journal Antennas and Propagation in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Open Journal of Antennas and Propagation' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));


---------------- Scenario#4 Verify the with publication type -> publication name with more than one template. --------------------
---------------- IEEE Open Journal of Antennas and Propagation --------------------

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Open Journal of Circuits and Systems ', '', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Word', 'IEEE-open-journal-template.doc', 'Please use this template when writing an original research article for IEEE Open Journal of Circuits and Systems in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Open Journal of Circuits and Systems ' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'LaTeX', 'IEEE-open-journal-template.zip', 'Please use this template when writing an original research article for IEEE Open Journal of Circuits and Systems in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Open Journal of Circuits and Systems ' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

 ---------------- Scenario#5 Verify the publication type -> publication name with only one article type and only one format. --------------------
---------------- IEEE Journal of Quantum Electronics --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Journal of Quantum Electronics', 'JQE', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Original research', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Quantum Electronics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'JQE-Template.doc', 'Please use this template when writing an original research article for IEEE Journal of Quantum Electronics in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Quantum Electronics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

 ---------------- Scenario#6 Verify the publication type -> publication name with only one article type and more than one format --------------------
---------------- IEEE Computer Architecture Letters --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Computer Architecture Letters', 'LCA', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Original research', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Computer Architecture Letters' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'Trans_final_submission.docx', 'Please use this template when writing an original research article for IEEE Computer Architecture Letters in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Computer Architecture Letters' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'LaTeX', 'Computer_Society_LaTeX_template.zip', 'Please use this template when writing an original research article for IEEE Computer Architecture Letters on a Windows or Macintosh computer in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Computer Architecture Letters' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'LaTeX for Unix', 'cs_template_latex.tar', 'Please use this template when writing an original research article for IEEE Computer Architecture Letters in LaTeX format on a Unix computer.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Computer Architecture Letters' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));


 ---------------- Scenario#7 Verify the publication type -> publication name with more than one article type and only one format. --------------------
---------------- IEEE Journal of Translational Engineering in Health and Medicine --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Journal of Translational Engineering in Health and Medicine', 'JTEHM', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Original research', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Translational Engineering in Health and Medicine' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Challenge papers', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Translational Engineering in Health and Medicine' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'JTEHM_Template.doc', 'Please use this template when writing an original research article for IEEE Journal of Translational Engineering in Health and Medicine in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Translational Engineering in Health and Medicine' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'JTEHM_Challenge_Papers_Template.doc', 'Please use this template when writing a Challenge paper for IEEE Journal of Translational Engineering in Health and Medicine in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Challenge papers' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Translational Engineering in Health and Medicine' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));


 ---------------- Scenario#8 Verify the publication type -> publication name with more than one article type and more than one format. --------------------
---------------- IEEE Journal of Biomedical and Health Informatics --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Journal of Biomedical and Health Informatics', 'JBHI', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Original research', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO ARTICLE_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TITLE_ID) VALUES (
'Brief', 'Template type to publish new Journal', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters')));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

 INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'Alternate-Transactions-Articles-template.doc', 'Please use this template when writing an original research article for IEEE Journal of Biomedical and Health Informatics in Microsoft Word format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'LaTeX', 'Alternate-Transactions-Articles-LaTeX-template.zip', 'Please use this template when writing an original research article for IEEE Journal of Biomedical and Health Informatics in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Original research' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'Word', 'Alternate-Transactions-brief-short-technical-notes-or-communications-article-template.doc', 'Please use this template when writing a brief article for IEEE Journal of Biomedical and Health Informatics in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Brief' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));

INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO TEMPLATE_FILE (FORMAT, NAME, DESCRIPTIVE_TEXT, STATUS, AUDIT_INFO_ID, ARTICLE_TYPE_ID) VALUES (
'LaTeX', 'Alternate-Transactions-Brief-LaTeX-template.zip', 'Please use this template when writing a brief article for IEEE Journal of Biomedical and Health Informatics in LaTeX format.', 'Active', LAST_INSERT_ID(),
(SELECT ID FROM ARTICLE_TYPE WHERE NAME = 'Brief' AND PUBLICATION_TITLE_ID = (SELECT ID FROM PUBLICATION_TITLE WHERE NAME = 'IEEE Journal of Biomedical and Health Informatics' AND PUBLICATION_TYPE_ID = (SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters'))));


---------------- For EDGE cases --------------------
---------------- Verify the Publication type without Publication name or Template --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Book_Edge', 'Blank', 'InActive', LAST_INSERT_ID() );

---------------- Verify the Publication name without Article or Template --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TYPE (NAME, DESCRIPTION, STATUS, AUDIT_INFO_ID) VALUES (
'Transactions, Journals and Letters_Edge', 'Template type to publish new Journal', 'InActive', LAST_INSERT_ID() );


---------------- Verify the Publication name without Article or Template --------------------
INSERT INTO AUDIT_INFO (CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (
'Admin', CURRENT_TIMESTAMP, 'Admin', CURRENT_TIMESTAMP);

INSERT INTO PUBLICATION_TITLE (NAME, ACRONYM, DESCRIPTION, STATUS, AUDIT_INFO_ID, PUBLICATION_TYPE_ID) VALUES (
'IEEE Edge test', 'JBHI', 'Template type to publish new Journal_edge', 'InActive', LAST_INSERT_ID(),
(SELECT ID FROM PUBLICATION_TYPE WHERE NAME = 'Transactions, Journals and Letters_Edge'));