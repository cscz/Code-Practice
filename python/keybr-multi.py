import time
from selenium import webdriver
import random

letter_selector = "span.TextInput-item"
close_tour_selector = "a.Tour-close"
focus_input_selector = ".TextInput.TextInput--sizeX0"
focus_input_selector = ".TextInput.TextInput--sizeX0.TextInput--inactive"
race_title_selector = "#App > div > div > div.Track > div.Ticker"

driver=webdriver.Safari()
#driver.get('https://www.keybr.com/profile')
#driver.get('https://www.keybr.com')
driver.maximize_window()
driver.get('https://www.keybr.com/multiplayer')
print(driver.get_cookies())

#time.sleep(2)
#try:
#    driver.find_element_by_css_selector(close_tour_selector).click()
#except Exception:
#    pass
#    print("11")

#driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div[1]/button[6]').click()
#try:
#    driver.find_element_by_css_path('html.theme--size-x1 body.Body div.Body-container main#App.Body-app div#root.Practice-placeholder section.Settings div.TabList div.TabList-body div.u-gridRow div fieldset.FieldSet p.u-fieldList span.u-field label.CheckBox').click()
#    #driver.find_element_by_css_selector('p.u-fieldList:nth-child(3) > span:nth-child(1) > label:nth-child(1)').click()
#    #driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div[2]/div[1]/div[2]/fieldset[1]/p[3]/span[1]/label/svg').click()
#    #driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div[2]/div[1]/div[2]/fieldset[1]/p[3]/span[2]/label/svg').click()
#except Exception:
#    print("11")	


#driver.find_element_by_xpath('/html/body/div[1]/main/div/section/div/div[2]/div[2]/button').click()

try:
    driver.find_element_by_css_selector(close_tour_selector).click()
except:
    pass

try:
    driver.find_element_by_css_selector(focus_input_selector).click()
except:
    pass


for j in range(1, 100):
    driver.get('https://www.keybr.com/multiplayer')
    kkk = " "
    while "GO" not in kkk:
        try:
            kkk=driver.find_element_by_css_selector(race_title_selector).text
        except:
            print(kkk)
        time.sleep(1)
        print(kkk)
    
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
        if random.randint(1,101) > 96:
            i.send_keys(";")
        i.send_keys(value) 
    print("race finished!")

#time.sleep(10)
#driver.close()

