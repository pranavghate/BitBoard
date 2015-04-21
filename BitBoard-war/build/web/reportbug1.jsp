<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>:: Bulletin Board ::</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">BitBoard <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                          <a class="home" href="index.html" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="contact" href="developers.html" rel="tooltip" data-placement="bottom" data-original-title="Developers"></a>
                         <a class="about" href="aboutus.html" rel="tooltip" data-placement="bottom" data-original-title="About Us"></a>
                          <a class="tut" href="tutorial.html" rel="tooltip" data-placement="bottom" data-original-title="Tutorial"></a>
                          <a class="bug" href="bugreport.html" rel="tooltip" data-placement="bottom" data-original-title="Bug Reporting"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
            	<div class="register span12" style="background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;">
                <h2 class="red" align="center">Report a Bug</h2>
                </div>
            </div>
            <br>
            <div class="row">
            	<div class="register span12" style="background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px; height:10px">
                <form action="Bugserv" method="post">
                <label for="Title">Give a Title</label>
                        <input type="text" id="bugtitle" name="bugtitle" placeholder="Enter a title">
                        <label for="Content">Give an explanation</label>
                        <textarea id="bugcon" name="bugcon" placeholder="Please elaborate the bug."></textarea><br>
                       <button type="submit">Report Bug</button>
                        </form>
                </div>
            </div>
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>


