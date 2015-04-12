<?php
$value = $_GET['query'];
$formfield = $_GET['field'];

if ($formfield == "firstname")
{
	if(!preg_match("/[A-Z]/",$value))
	{
		echo "Please start with capital letter";
	}
	else
	{
		echo "<span>Valid</span>";	
	}
	
}
if ($formfield == "lastname")
{
	if(!preg_match("/[A-Z]/",$value))
	{
		echo "Please start with capital letter";
	}
	else
	{
		echo "<span>Valid</span>";	
	}
	
}
if ($formfield == "department")
{
	if(strlen($value)<5 || $value=="")
	{
		echo "Please senter well defined department";
	}
	else
	{
		echo "<span>Valid</span>";	
	}
	
}
if ($formfield == "comp")
{
	if(strlen($value)<5 || $value=="")
	{
		echo "Please senter well defined compay name.Avoid abbreviations.";
	}
	else
	{
		echo "<span>Valid</span>";	
	}
	
}
if ($formfield == "phonenum")
{
	if(!preg_match("/^\d+$/",$value) || strlen($value)!=10)
	{
		echo "Enter only Numeric Values/ Not Long enough";
	}
	else
	{
		echo "<span>Valid</span>";
	}
}
if ($formfield == "username")
{
	if(strlen($value)<4)
	{
		echo "Must be greater than 4 letters";
	}
	else
	{
		echo "<span>Valid</span>";
	}
	
}
if ($formfield == "password")
{
	if(strlen($value)<4)
	{
		echo "Must be greater than 4 letters";
	}

}

?>