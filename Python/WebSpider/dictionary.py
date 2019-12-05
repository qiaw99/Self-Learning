import json
import time
import urllib.parse
import urllib.request

url = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=http://www.youdao.com"

while True:
	content = input("What to translate: \n")
	if(content == 'q!'):
		break

	#head = {}
	#head['Referer'] = 'http://fanyi.youdao.com'
	#head['User-Agent'] = 'Mozilla/5.0(Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36(KJTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36X-Requested-With:XMLHttpRequest'

	data = {}
	data['type'] = 'AUTO'
	data['i'] = 'Joking'
	data['doctype'] = 'json'
	data['xmlVersion'] = '1.6'
	data['keyfrom'] = 'fanyi.web'
	data['ue'] = 'UTF-8'
	data['typoResult'] = 'true'
	data = urllib.parse.urlencode(data).encode('utf-8')

	req = urllib.request.Request(url, data)
	req.add_header('Referer', 'http://fanyi.youdao.com')
	req.add_header('User-Agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362')
	response = urllib.request.urlopen(req)
	html = response.read().decode('utf-8')

	target = json.loads(html)
	print("Result: %s" %(target['translateResult'][0][0]['tgt']))
	time.sleep(5)
