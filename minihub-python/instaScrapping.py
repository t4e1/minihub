from playwright.async_api import async_playwright

async def scrape_instagram():
    async with async_playwright() as p:
        browser = await p.chromium.launch(headless=False, slow_mo=50)
        page = await browser.new_page()
        await page.goto('https://google.com')
        return "Scraping Completed"