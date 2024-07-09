from playwright.sync_api import sync_playwright
from bs4 import BeautifulSoup

with sync_playwright() as p:
    browser = p.chromium.launch()
    page = browser.new_page()
    page.goto("https://m.blog.naver.com/PostList.naver?blogId=smdcmart&tab=1")
    page.screenshot(path="demo.png")
    browser.close()