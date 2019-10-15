# AuthorTemplate
Application to guide public users to choose appropriate template for publishing book, magazine, article, etc


localhost:8001/getTemplateType

{
  "name": "Book",
  "description": "New Book publishing",
  "status": "Active",
  "createdBy": "Admin",
  "createdDate": "2014-01-01T23:28:56.782Z",
  "modifiedBy": "Admin",
  "modifiedDate": "2014-01-01T23:28:56.782Z",
  "fileDownloadList": [
    {
      "format": "Latex for linux",
      "url": "/asdfasdf_latex_linux.zip",
      "descriptiveText": "Book in Latex format"
    },
    {
      "format": "word",
      "url": "/asdfasdf_word.doc",
      "descriptiveText": "Book in word format"
    },
    {
      "format": "Latex",
      "url": "/asdfasdf_latex.zip",
      "descriptiveText": "Book in Latex format"
    }
  ]
}

{
  "name": "Magazine",
  "description": "New Magazine",
  "status": "Active",
  "createdBy": "Admin",
  "createdDate": "2014-01-01T23:28:56.782Z",
  "modifiedBy": "Admin",
  "modifiedDate": "2014-01-01T23:28:56.782Z",
  "templateNameList": [
	{
		"name": "India today",
		"description": "weekly update about India",
		"status": "Active",
		"createdBy": "Admin",
		"createdDate": "2014-01-01T23:28:56.782Z",
		"modifiedBy": "Admin",
		"modifiedDate": "2014-01-01T23:28:56.782Z",
		"fileDownloadList": [
			{
			  "format": "word",
			  "url": "/india_today_word.doc",
			  "descriptiveText": "India today Magazine in word format"
			},
			{
			  "format": "Latex",
			  "url": "/india_today_latex.zip",
			  "descriptiveText": "India today Magazine in Latex format"
			}
		  ]
	},
	{
		"name": "Economic Times",
		"description": "Monthly update on world economics",
		"status": "Active",
		"createdBy": "Admin",
		"createdDate": "2014-01-01T23:28:56.782Z",
		"modifiedBy": "Admin",
		"modifiedDate": "2014-01-01T23:28:56.782Z",
		"fileDownloadList": [
			{
			  "format": "word",
			  "url": "/economic_times_word.doc",
			  "descriptiveText": "Economic times Magazine in word format"
			}
		  ]
	}
  ]
}

{
  "name": "Journals",
  "description": "Journal Paper",
  "status": "Active",
  "createdBy": "Admin",
  "createdDate": "2014-01-01T23:28:56.782Z",
  "modifiedBy": "Admin",
  "modifiedDate": "2014-01-01T23:28:56.782Z",
  "templateNameList": [
	{
		"name": "New Inventions",
		"description": "Journals about New Inventions",
		"status": "Active",
		"createdBy": "Admin",
		"createdDate": "2014-01-01T23:28:56.782Z",
		"modifiedBy": "Admin",
		"modifiedDate": "2014-01-01T23:28:56.782Z",
		"articleTypeList": [
			{
				"name": "Electrical Journal Paper",
				"description": "Electrical Journals about New Inventions",
				"status": "Active",
				"createdBy": "Admin",
				"createdDate": "2014-01-01T23:28:56.782Z",
				"modifiedBy": "Admin",
				"modifiedDate": "2014-01-01T23:28:56.782Z",
				"fileDownloadList": [
					{
					  "format": "word",
					  "url": "/electrical_journal_word.doc",
					  "descriptiveText": "Electrical Journal in word format"
					},
					{
					  "format": "Latex",
					  "url": "/electrical_journal_latex.zip",
					  "descriptiveText": "Electrical Journal in Latex format"
					}
				]
			},
			{
				"name": "Electronics and communication Journal Paper",
				"description": "Electronics and communication Journals about New Inventions",
				"status": "Active",
				"createdBy": "Admin",
				"createdDate": "2014-01-01T23:28:56.782Z",
				"modifiedBy": "Admin",
				"modifiedDate": "2014-01-01T23:28:56.782Z",
				"fileDownloadList": [
					{
					  "format": "Latex",
					  "url": "/electronics_and_communication_journal_latex.zip",
					  "descriptiveText": "Electronics and communication Journal in Latex format"
					}
				]
			}
		]
	}
  ]
}

select * from template_type;
select * from template_name;
select * from Article_type;
select * from FILE_DOWNLOAD;