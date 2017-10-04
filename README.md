# Haskell Cookbook
This is the code repository for [Haskell Cookbook](https://www.packtpub.com/application-development/haskell-cookbook?utm_source=github&utm_medium=repository&utm_campaign=9781786461353), published by [Packt](https://www.packtpub.com/?utm_source=github). It contains all the supporting project files necessary to work through the book from start to finish.
## About the Book
Haskell is a purely functional language that has the great ability to develop large and difficult, but easily maintainable, software.
## Instructions and Navigation
All of the code is organized into folders. Each folder starts with a number followed by the application name. For example, Chapter02.

All the code files are present in their respective code folders.

The code will look like the following:
```
reverse :: [a] -> [a]
reverse xs = reverse' xs []
where
  reverse' :: [a] -> [a] -> [a]
  reverse' [] rs = rs
  reverse' (x:xs) rs = reverse' xs (x:rs)
```

You will need a fairly recent operating system, such as Windows, Linux, or Mac
OS.

You should set up the stack tool from https://www.haskellstack.org/. Use the
Stack setup to download GHC (Haskell Compiler) on your machine. Stack is an
extremely useful tool to work with different versions of GHC and packages.

You will need a good editor. Vi and Emacs have very good support for Haskell.
Eclipse and Sublime also have support for Haskell.

## Related Products
* [Haskell Data Analysis Cookbook](https://www.packtpub.com/big-data-and-business-intelligence/haskell-data-analysis-cookbook?utm_source=github&utm_medium=repository&utm_campaign=9781783286331)

* [Mastering Haskell Programming [Video]](https://www.packtpub.com/application-development/mastering-haskell-programming-video?utm_source=github&utm_medium=repository&utm_campaign=9781786465016)

* [Building an Application with Functional Haskell [Video]](https://www.packtpub.com/application-development/building-application-functional-haskell-video?utm_source=github&utm_medium=repository&utm_campaign=9781787285088)

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSe5qwunkGf6PUvzPirPDtuy1Du5Rlzew23UBp2S-P3wB-GcwQ/viewform) if you have any feedback or suggestions.
