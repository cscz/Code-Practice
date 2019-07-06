import time
import pdb
from selenium import webdriver
import random

letter_selector = "span.TextInput-item"
close_tour_selector = "a.Tour-close"
focus_input_selector = ".TextInput.TextInput--sizeX0"
focus_input_selector = ".TextInput.TextInput--sizeX0.TextInput--inactive"
race_title_selector = "#App > div > div > div.Track > div.Ticker"

driver=webdriver.Safari()
driver.maximize_window()
driver.get('https://www.keybr.com/profile')
driver.get('https://www.keybr.com')

#time.sleep(2)
#try:
#    driver.find_element_by_css_selector(close_tour_selector).click()
#except Exception:
#    pass

driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div[1]/button[6]').click()

#Maybe add some setting here

driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div[2]/div[2]/button').click()

driver.get('https://www.keybr.com/profile')
driver.get('https://www.keybr.com')
print(driver.get_cookies())

#pdb.set_trace()
try:
    driver.find_element_by_css_selector(close_tour_selector).click()
except:
    pass

try:
    driver.find_element_by_css_selector(focus_input_selector).click()
except:
    pass


for j in range(1, 30):
    try:
        driver.find_element_by_css_selector(focus_input_selector).click()
    except:
        pass
    
    letters = driver.find_elements_by_css_selector(letter_selector)

    #letters[0].send_keys(".")
    for i in letters:
        if i.text == " ":
        	continue
        
        if i.text == "↵": 
        	#i.send_keys("↵")
        	i.send_keys("\n")
        	continue
        value = i.text if i.text != "␣" else " "
        time.sleep(0.037)
        #time.sleep(0.08)
        #if random.randint(1,101) > 96:
        #    i.send_keys(";")
        i.send_keys(value) 
    print("race finished!")

driver.execute_script("window.localStorage.getItem('settings');")
print(" ")
#time.sleep(10)
#driver.close()

