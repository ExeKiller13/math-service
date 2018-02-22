import { MathServiceClientPage } from './app.po';

describe('math-service-client App', function() {
  let page: MathServiceClientPage;

  beforeEach(() => {
    page = new MathServiceClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
