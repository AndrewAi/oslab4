# oslab4


Operating	Systems	Laboratory
Lab	4
Lab	Reports	 (Including	source	code and	screenshots)	 to	be	submitted	 to	Moddle	by	21st October	
2016	at	12noon
Write	a	program	(Java	or	C) for	the	implementation	of	the	following	Process	Scheduling	Algorithm.	
1. FCFS	
2. SJF	
3. Round	Robin	
The	program	should	prompt	 the	user	 to	enter	 the	number	of	process	 to	be	scheduled	and	 then	should	
prompt	the	user	for	the	processing	times	of	each	individual	process.
Once	the	user	is	finished	entering	the	process	times they	are	prompted	to	choose	a	scheduling	algorithm	
and	in	the	case	of	Round	Robin	the	user	is	prompted	for	the	time	quantum.
The	program	should	clear	show:
• When	a	process	starts	in	the	CPU
• When	a	process	finishes	or	is	pre-empted	from	the	processor
• The	average	wait	time	for	each	process
• The	average	wait	time	for	the	system
Enter	the	process	name	and	burst	time	for	the	process
Enter	the	process	name	1
Enter	the	burst	time	for	the	process:	1
10
Enter	the	process	name	2
Enter	the	burst	time	for	the	process:	2
7
Enter	the	process	name	3
Enter	the	burst	time	for	the	process:	3
10
Press	1	round	robin	
Press	2	FCFS	
Press	3 SJF
Press	4 to	exit
1
Process	name					 Start	Time Remaining	time												 Wait	Time
1																															 0 5																													 0
2																																5 5																												 5
3																															 10
5																												 10
1																															 15
0 																											 10
2																															 20																									
0						 15
3																															 22																											
0				 17
Average	Wait	Time	is:	19
